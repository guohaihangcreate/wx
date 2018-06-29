package com.create.core;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.net.URLCodec;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;

import com.create.util.WxAuthUtil;

import net.sf.json.JSONObject;
//微信入口地址
@WebServlet("/WxAuthLogInServlet")
public class WxAuthLogInServlet extends HttpServlet {

	
	private static final long serialVersionUID = -2957653326431110490L;
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String callbackUrl = "";
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+WxAuthUtil.APPID
				+ "&redirect_uri="+URLEncoder.encode(callbackUrl)
				+ "I&response_type=code"
				+ "&scope=snsapi_userinfo"
				+ "&state=STATE#wechat_redirect";
		response.sendRedirect(url);
	}

}
