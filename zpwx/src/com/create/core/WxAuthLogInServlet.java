package com.create.core;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.create.po.UserInfo;
import com.create.util.WxAuthUtil;

import net.sf.json.JSONObject;
//微信入口地址
@WebServlet("/WxAuthLogIn")
public class WxAuthLogInServlet extends HttpServlet {

	private static final long serialVersionUID = -2957653326431110490L;
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String callbackUrl = "http://weixin.xiangmu.ren/zpwx/callback";
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+WxAuthUtil.APPID
				+ "&redirect_uri="+URLEncoder.encode(callbackUrl)
				+ "&response_type=code"
				+ "&scope=snsapi_userinfo"
				+ "&state=STATE#wechat_redirect";
		try {
			response.sendRedirect(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
