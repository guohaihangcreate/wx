package com.create.dao;

import java.io.FileInputStream;
import java.util.Properties;

public class DaoFactory {

	private static UserDao userdao=null;
    private static DaoFactory instance= new DaoFactory();
    
//    private DaoFactory(){  
//        /** 
//         * 通过读取属性文件来动态的加载Dao层类 
//         */  
//        Properties prop = new Properties();  
//        try{  
//            FileInputStream fis = new FileInputStream("src/resources/jdbcconfig.properties");  
//            prop.load(fis);  
//            String className = prop.getProperty("userDaoClass");  
//            Class<?> clazz = Class.forName(className);  
//            userdao = (UserDao)clazz.newInstance();  
//            fis.close();  
//        }catch(Exception e){  
//        }  
//    }  
    
    private DaoFactory(){
        try {
            userdao=(UserDao)Class.forName("com.create.service.Jdbc_Service").newInstance();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }
    
    public static DaoFactory getInstance(){
        return instance;
    }
    
    public UserDao createUserDao(){
        return userdao;
    }

}
