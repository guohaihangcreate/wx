package com.create.test;

import com.create.po.AccessToken;
import com.create.util.WxAuthUtil;

import net.sf.json.JSONObject;

public class CreateMenue {

	public CreateMenue() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccessToken accessToken = WxAuthUtil.getAccessToken();
		System.out.println("获取票据："+accessToken.getToken());
		System.out.println("票据有效时间："+accessToken.getExpires());
		String menue = JSONObject.fromObject(WxAuthUtil.initMenue()).toString();
		int result = WxAuthUtil.createMenue(accessToken.getToken(), menue);
		System.out.println(result);
		if(result==0) {
			System.out.println("创建菜单成功!");
		}else {
			System.out.println(result);
		}
	}

}
