package com.create.po;

public class AccessToken {
//	获取到的凭证
	private String token;
//	凭证有效时间，单位：秒
	private int expires;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	public int getExpires() {
		return expires;
	}
	public void setExpires(int expires) {
		this.expires = expires;
	}
	

}
