package com.yhh.service;

import java.util.List;

import com.yhh.pojo.User;

public interface UserService {
	
	User checkUserLoginService(String uname,String pwd);
	
	int userChangePwdService(String newPwd, int uid);
	
	List<User> userShowService();
	
	int userRegService(User u);
	
	User checkUidService(String uid);
}
