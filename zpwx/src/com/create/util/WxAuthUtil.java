package com.create.util;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;

public class WxAuthUtil {
	
	public static final String APPID="wxc2c705d84eec52ed";
	
	public static final String APPSECRET="3a6e5c939072c88397741382db94191b";
	
	public  static  JSONObject doGetJson(String url) {
		JSONObject jsonObject = null;
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet(url);
		try {
			HttpResponse httpresponse = httpClient.execute(httpget);
			HttpEntity httpEntity = httpresponse.getEntity();
			if(httpEntity!=null) {
				String result = EntityUtils.toString(httpEntity, "UTF-8");
				if(StringUtils.isNotBlank(result)) {
					jsonObject = JSONObject.fromObject(result);
				}
			}
			httpget.releaseConnection();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}

}
