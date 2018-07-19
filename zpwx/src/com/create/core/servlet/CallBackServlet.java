package com.create.core.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.create.po.UserInfo;
import com.create.util.WeiXinUtil;
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
//		String userurl = "https://api.weixin.qq.com/cgi-bin/user/info?access_token="+token
//				+ "&openid="+openid
//				+ "&lang=zh_CN";
		String userUrl = "https://api.weixin.qq.com/sns/userinfo?access_token="+token
				+ "&openid="+openid
				+ "&lang=zh_CN";
		//获取用户信息
		JSONObject userInfoObject = WxAuthUtil.doGetJson(userUrl);
		UserInfo userinfo = new UserInfo();
		userinfo.setNickname(userInfoObject.getString("nickname"));
		userinfo.setCountry(userInfoObject.getString("country"));
		userinfo.setCity(userInfoObject.getString("city"));
		userinfo.setProvince(userInfoObject.getString("province"));
		userinfo.setHeadimgurl(userInfoObject.getString("headimgurl"));
		userinfo.setPrivilege(userInfoObject.getString("province"));
		userinfo.setUnionid(userInfoObject.getString("privilege"));
		userinfo.setSex(userInfoObject.getString("sex"));
		request.getSession().setAttribute("userinfo", userinfo);
		request.setAttribute("userinfo", userinfo);
//		String menueUrl= "https://api.weixin.qq.com/cgi-bin/menu/get?access_token="
//				+ WeiXinUtil.getAccessToken().getToken();
//				JSONObject menueObject =WeiXinUtil.doPostStr(menueUrl);
//		request.getRequestDispatcher("/myinfo.jsp").forward(request, response);
		request.getRequestDispatcher("/wx/wx_main.jsp").forward(request, response);
	}

}
