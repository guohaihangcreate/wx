package com.create.test;

import com.create.po.AccessToken;
import com.create.util.WeiXinUtil;

public class TestGetAcessToken {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccessToken accessToken = WeiXinUtil.getAccessToken();
		System.out.println("获取票据："+accessToken.getToken());
		System.out.println("票据有效时间："+accessToken.getExpires());
	}

}
