package com.yhh.dao;

import java.util.List;

import com.yhh.pojo.User;

public interface UserDao {
	/**
	 * 根据用户名和密码查询用户信息
	 * @param uname 用户名
	 * @param pwd	密码
	 * @return 返回查询到的用户信息
	 */
	User checkUserLoginDao(String uname,String pwd);
	/**
	 * 根据用户ID修改用户密码
	 * @param newPwd
	 * @param uid
	 * @return
	 */
	int userChangePwdDao(String newPwd, int uid);
	/**
	 * 获取所有的用户信息
	 * @return
	 */
	List<User> userShowDao();
	/**
	 * 用户注册
	 * @param u
	 * @return
	 */
	int userRegDao(User u);
	
	//根据uid获取用户信息
		User checkUidDao(String uid);
}
