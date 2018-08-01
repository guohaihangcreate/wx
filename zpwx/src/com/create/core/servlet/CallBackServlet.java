package com.create.core.servlet;

import java.io.IOException;
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
import com.create.util.WxAuthUtil;

import net.sf.json.JSONObject;
@WebServlet("/callback")
public class CallBackServlet extends HttpServlet {

	public CallBackServlet() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+WxAuthUtil.APPID
				+ "&secret="+WxAuthUtil.APPSECRET
				+ "&code="+code
				+ "&grant_type=authorization_code";		
		JSONObject authObject = WxAuthUtil.doGetJson(url);
		String token = authObject.getString("access_token");
		String openid = authObject.getString("openid");
		String userUrl = "https://api.weixin.qq.com/sns/userinfo?access_token="+token
				+ "&openid="+openid
				+ "&lang=zh_CN";
		Wx_user userinfo = null;
		Wx_userServices wx_userServices=new Wx_userServices();
		List<Wx_user> userinfos = null;
		if(StringUtils.isNotBlank(openid)) {
			 userinfos= wx_userServices.query(openid);
		}
		if(userinfos==null||userinfos.size()==0) {
			userinfo = new Wx_user();
			JSONObject userInfoObject = WxAuthUtil.doGetJson(userUrl);
			String nickname = userInfoObject.getString("nickname");
			String country = userInfoObject.getString("country");
			String city = userInfoObject.getString("city");
			String province = userInfoObject.getString("province");
			String headimgurl = userInfoObject.getString("headimgurl");
			String privilege = userInfoObject.getString("privilege");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if(userInfoObject.has("unionid")) {
				String unionid = userInfoObject.getString("unionid");
				userinfo.setUnionid(unionid);
			}
			String sex = userInfoObject.getString("sex");
			userinfo.setNickname(nickname);
			userinfo.setCountry(country);
			userinfo.setCity(city);
			userinfo.setProvince(province);
			userinfo.setHeadimgurl(headimgurl);
			userinfo.setPrivilege(privilege);
			userinfo.setLogintype(0);//注册状态，1为已经注册，0为未注册
			String time= sdf.format( new Date());
			try {
				Date createtime=sdf.parse(time);
				userinfo.setCreatetime(createtime);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(StringUtils.isNotBlank(sex)) {
				userinfo.setSex(Integer.valueOf(sex));
			}
			userinfo.setOpenid(openid);
	        wx_userServices.regist(userinfo); 
		}else {
			if(userinfos!=null&&userinfos.size()>0) {
				userinfo=userinfos.get(0);
			}
		}
		request.getSession().setAttribute("userinfo", userinfo);
		request.setAttribute("userinfo", userinfo);
		request.getRequestDispatcher("/login_wx.jsp").forward(request, response);
	}

}
