package com.create.po;

public class AccessToken {
//	��ȡ����ƾ֤
	private String token;
//	ƾ֤��Чʱ�䣬��λ����
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
