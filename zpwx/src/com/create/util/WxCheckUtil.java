package com.create.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;;

public class WxCheckUtil {

	public WxCheckUtil() {
		// TODO Auto-generated constructor stub
	}

	private static final String token ="create";
	
	public static boolean checkSignature(String signature,String timestamp,String nonce) {
		String[] arr= new String[]{token,timestamp,nonce}; 
		Arrays.sort(arr);
		//拼接排序好的字符串
		StringBuffer content = new StringBuffer();
		for(int i=0;i<arr.length;i++) {
			content.append(arr[i]);
		}
		//对排序好的字符串进行sha1加密
		String wxtemp = getSha1(content.toString());
		return wxtemp.equals(signature);
	}
	
	
	//下面四个import放在类名前面 包名后面
	//import java.io.UnsupportedEncodingException;
	//import java.security.MessageDigest;
	//import java.security.NoSuchAlgorithmException;
	//import java.util.Arrays;
	public static String getSha1(String str){
		char[] buf = null; 
	    if (null == str || 0 == str.length()){
	        return null;
	    }
	    char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
	            'a', 'b', 'c', 'd', 'e', 'f'};
	    try {
	        MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
	        mdTemp.update(str.getBytes("UTF-8"));
	         
	        byte[] md = mdTemp.digest();
	        int j = md.length;
	        buf = new char[j * 2];
	        int k = 0;
	        for (int i = 0; i < j; i++) {
	            byte byte0 = md[i];
	            buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
	            buf[k++] = hexDigits[byte0 & 0xf];
	        }
	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    } catch (UnsupportedEncodingException e) {
	        e.printStackTrace();
	    }
	    return new String(buf);
	}
}
