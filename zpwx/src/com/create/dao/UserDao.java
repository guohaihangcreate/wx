package com.create.dao;

import java.util.List;

import com.create.po.Wx_user;

public interface UserDao {
	
	public abstract void addUser(Wx_user user);
	
	public List<Wx_user> getUserByOpenId(String openId);
	
	public List<Wx_user> queryByModel(Wx_user wx_user);
	

	public abstract Wx_user getUserById(int userid);

	public abstract int update(Wx_user user);

	public abstract int delete(Wx_user user);
}
