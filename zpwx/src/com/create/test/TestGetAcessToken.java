package com.create.test;

import com.create.po.AccessToken;
import com.create.util.WeiXinUtil;

public class TestGetAcessToken {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccessToken accessToken = WeiXinUtil.getAccessToken();
		System.out.println("��ȡƱ�ݣ�"+accessToken.getToken());
		System.out.println("Ʊ����Чʱ�䣺"+accessToken.getExpires());
	}

}
