package com.create.core.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.create.util.WxAuthUtil;

import net.sf.json.JSONObject;
@WebServlet("/callback")
public class CallBackServlet extends HttpServlet {

	public CallBackServlet() {
		// TODO Auto-generated constructor stub
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) {
		String code = request.getParameter("code");
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+WxAuthUtil.APPID
				+ "&secret="+WxAuthUtil.APPSECRET
				+ "&code="+code
				+ "&grant_type=authorization_code";
		JSONObject jsonObject = WxAuthUtil.doGetJson(url);
		String openId = jsonObject.getString("openid");
		String token = jsonObject.getString("access_token");
		String userUrl="https://api.weixin.qq.com/sns/userinfo?access_token="+token
				+ "&openid="+openId
				+ "&lang=zh_CN";
		JSONObject user_json = WxAuthUtil.doGetJson(userUrl);
		
	}

}
