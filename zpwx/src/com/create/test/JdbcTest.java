package com.create.test;

import com.create.po.Wx_user;
import com.create.service.Wx_userServices;

public class JdbcTest {
//测试添加用户的jdbc数据库服务
	public JdbcTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
        // TODO Auto-generated method stub
		Wx_userServices wx_userServices=new Wx_userServices();
        Wx_user wx_user = new Wx_user();
        wx_user.setNickname("测试用户名称");
        wx_userServices.regist(wx_user); //这句话我们也可以这样
        //userse.regist(new User(1,"clearlove","1995-01-26",300));这样写我们可以固定传参...但是上面的一些代码就要进行修改了...
    }
}
