package com.create.util;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.create.po.AccessToken;
import com.create.po.menue.Button;
import com.create.po.menue.ClickButton;
import com.create.po.menue.Menue;
import com.create.po.menue.ViewButton;

import net.sf.json.JSONObject;

@SuppressWarnings("deprecation")
public class WxUtil {
	
	public static final String APPID="wxc2c705d84eec52ed";
	
	public static final String APPSECRET="3a6e5c939072c88397741382db94191b";
	
	
	private static final String ACCESS_TOKEN_URL="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	
	private static final String CREATE_MENUEURL="https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	
	private static final String QUERY_MENUEURL="https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
	
	private static final String DELETE_MENUEURL="https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
	
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
	
	/*
	 * 获取post请求
	 */
	public static JSONObject doPostJSON(String url,String outStr) {
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
	
	public static AccessToken getAccessToken() {
		AccessToken token = new AccessToken();
		String url = ACCESS_TOKEN_URL.replace("APPID", APPID).replace("APPSECRET", APPSECRET);
		JSONObject jsonobject = doGetJson(url);
		if(jsonobject!=null) {
			token.setToken(jsonobject.getString("access_token"));
			token.setExpires(jsonobject.getInt("expires_in"));
		}
		return token;
	}
	
	public static Menue initMenue() {
		Menue menue = new Menue();
		ClickButton button11 = new ClickButton();
		button11.setKey("click菜单");
		button11.setType("click");
		button11.setKey("11");
		
		ViewButton button21 = new ViewButton();
		button21.setName("view菜单");
		button21.setType("view");
		button21.setUrl("http://www.xiangmu.ren");
		
		ClickButton button31 = new ClickButton();
		button31.setName("扫码事件");
		button31.setType("scancode_push");
		button31.setKey("31");
		
		ClickButton button32 = new ClickButton();
		button32.setName("地理位置");
		button32.setType("location_select");
		button32.setKey("32");
		
		Button button = new Button();
		button.setName("菜单");
		button.setSub_button(new Button[] {button31,button32});
		menue.setButton(new Button[] {button11,button21,button});
		return menue;
	};
	
	public static int createMenue(String token,String menue) {
		int result=0;
		String url = CREATE_MENUEURL.replace("ACCESS_TOKEN", token);
		JSONObject jsonObject = doPostJSON(url, menue);
		if(jsonObject!=null) {
			result = jsonObject.getInt("errcode");
		}
		return result;
	}
	
	public static JSONObject queryMenue(String token,String menue) {
		int result=0;
		String url = QUERY_MENUEURL.replace("ACCESS_TOKEN", token);
		JSONObject jsonObject = doPostJSON(url, menue);
		return jsonObject;
	}
	
	public static int deleteMenue(String token) {
		int result=0;
		String url = DELETE_MENUEURL.replace("ACCESS_TOKEN", token);
		JSONObject jsonObject = doGetJson(url);
		if(jsonObject!=null) {
			result = jsonObject.getInt("errcode");
		}
		return result;
	}
}

