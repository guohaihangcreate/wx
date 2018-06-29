package com.create.util;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.create.po.AccessToken;

import net.sf.json.JSONObject;

public class WeiXinUtil {
	
	private static final String APPID="wxc2c705d84eec52ed";
	
	private static final String APPSECRET="3a6e5c939072c88397741382db94191b";
	
	private static final String ACCESS_TOKEN_URL="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	/*
	 * 获取get请求
	 */
	public static JSONObject doGetstr(String url) {
		JSONObject jsonobject = null;
		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet(url);
		HttpResponse httpResponse = null;
		try {
			httpResponse = httpclient.execute(httpget);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpEntity httpentity = httpResponse.getEntity();
		try {
			if(httpentity!=null) {
				String result = EntityUtils.toString(httpentity, "UTF-8");
				//把返回的字符串转换成jsonObject
				jsonobject = JSONObject.fromObject(result);
//				释放链接
				httpget.releaseConnection();
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonobject;
	}
	/*
	 * 获取post请求
	 */
	public static JSONObject doPostStr(String url,String outStr) {
		DefaultHttpClient httpclent = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		JSONObject jsonObject = null;
		httpPost.setEntity(new StringEntity(outStr, "utf-8"));
		try {
			HttpResponse response = httpclent.execute(httpPost);
			String result =EntityUtils.toString(response.getEntity(),"utf-8");
			jsonObject = JSONObject.fromObject(result);
			httpPost.releaseConnection();//释放链接
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;	
	}
	/*
	 * 获取accesstoken
	 */
	public static AccessToken getAccessToken() {
		AccessToken token = new AccessToken();
		String url = ACCESS_TOKEN_URL.replace("APPID", APPID).replace("APPSECRET", APPSECRET);
		JSONObject jsonobject = doGetstr(url);
		if(jsonobject!=null) {
			token.setToken(jsonobject.getString("access_token"));
			token.setExpires(jsonobject.getInt("expires_in"));
		}
		return token;
	}
}
