package com.create.core;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.create.po.Wx_user;
import com.create.service.Wx_userServices;
import com.create.util.Md5;
import com.create.util.WxAuthUtil;
//微信入口地址
@WebServlet("/wxAuthLogIn")
public class WxAuthLogInServlet extends HttpServlet {
	
	Md5 md5 = new Md5();

	private static final long serialVersionUID = -2957653326431110490L;
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String option_type = request.getParameter("type");
		Wx_userServices wx_userServices=new Wx_userServices();
		//认证操作
		if(StringUtils.isNotBlank(option_type)&&"auth".endsWith(option_type)) {//认证操作
			String callbackUrl = "http://weixin.xiangmu.ren/zpwx/callback";
			String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+WxAuthUtil.APPID
					+ "&redirect_uri="+URLEncoder.encode(callbackUrl)
					+ "&response_type=code"
					+ "&scope=snsapi_userinfo"
					+ "&state=STATE#wechat_redirect";
			response.sendRedirect(url);
		}else if(StringUtils.isNotBlank(option_type)&&"register".endsWith(option_type)){//注册操作
			try {
//				year_month = new String(year_month .getBytes("iso8859-1"),"utf-8");
				Wx_user wx_u = new Wx_user();
				String openid = request.getParameter("openid");
				wx_u.setOpenid(openid);
				String realname =new String(request.getParameter("realname").getBytes("iso8859-1"),"utf-8");
				wx_u.setRealname(realname);
				String email = request.getParameter("email");
				wx_u.setEmail(email);
				String password = new String(request.getParameter("password").getBytes("iso8859-1"),"utf-8");
				if(StringUtils.isNotBlank(password)) {
					wx_u.setPassword(md5.GetMD5Code(wx_u.getPassword()));
				}
				String sex = request.getParameter("sex");
				if(StringUtils.isNotBlank(sex)) {
					wx_u.setSex(Integer.valueOf(sex));
				}
				String birthday = request.getParameter("birthday");
				String enterDay = request.getParameter("enterDay");
				String mobile = request.getParameter("mobile");
				wx_u.setMobile(mobile);
				String idno = request.getParameter("idno");
				wx_u.setIdno(idno);
				//注册时间
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				SimpleDateFormat sdf_ymd = new SimpleDateFormat("yyyy-MM-dd");
				String time= sdf.format(new Date());
				try {
					wx_u.setEnterday(sdf_ymd.parse(enterDay));
					wx_u.setBirthday(sdf_ymd.parse(birthday));
					wx_u.setRegisterTime(sdf.parse(time));
					wx_u.setLogintype(1);//在已经注册的用户里面查询避免已经注册的用户，重复注册操作
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				List<Wx_user> list_wxuser = wx_userServices.queryByModel(wx_u);
				if(list_wxuser!=null&&list_wxuser.size()>0) {
					response.setContentType("text/html;charset=utf-8");
					PrintWriter out =response.getWriter();
					out .write("已经注册过了！如果忘记密码请找回密码");
					out.close();
				}else {
					wx_u.setLogintype(0);//重置状态为已经注册，并且已经实名登陆状态
					wx_userServices.update(wx_u);
					request.getSession().setAttribute("userinfo", wx_u);//更新session中的用户信息
				}
				request.getRequestDispatcher("/xzcx_month.jsp").forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(StringUtils.isNotBlank(option_type)&&"register".endsWith(option_type)){//登陆操作
			try {
				request.getRequestDispatcher("/xzcx_month.jsp").forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
