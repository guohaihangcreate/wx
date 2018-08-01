package com.create.service;

import java.util.List;

import com.create.dao.DaoFactory;
import com.create.dao.UserDao;
import com.create.po.Wx_user;

public class Wx_userServices {

	private UserDao userDao;
	
    public Wx_userServices(){
        userDao =DaoFactory.getInstance().createUserDao();//通过工厂实例化一个例子。。
        System.out.println("userDao "+userDao);
    }
    
    public void regist(Wx_user user){
        if(user==null){
            System.out.println("注册表信息无效...");
        }else{
            userDao.addUser(user);
        }
    }
    
    public List<Wx_user> queryByModel(Wx_user wx_user){  
    	List<Wx_user> Wx_users = userDao.queryByModel(wx_user);  
        return Wx_users;
    }  
    
    public List<Wx_user> query(String openId){  
    	List<Wx_user> Wx_users = userDao.getUserByOpenId(openId);  
        return Wx_users;
    } 
    
    public void update(Wx_user user){
        if(user.getId()<0){
            System.out.println("用户id无效,重新输入");
        }else{
            userDao.update(user);
        }
    }
    
    public void delete(Wx_user user){
        if(user.getId()<0){
            System.out.println("用户id无效,重新输入");
        }else{
            userDao.delete(user);
        }
    }
	

	
}
