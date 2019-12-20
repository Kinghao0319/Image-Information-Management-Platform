package com.yhh.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.yhh.dao.UserDao;
import com.yhh.dao.impl.UserDaoImpl;
import com.yhh.pojo.User;
import com.yhh.service.UserService;

public class UserServiceImpl implements UserService{
	
	Logger logger=Logger.getLogger(UserServiceImpl.class);
	UserDao ud=new UserDaoImpl();
	@Override
	public User checkUserLoginService(String uname, String pwd) {
		logger.debug(uname+"发起登录请求");
		User u=ud.checkUserLoginDao(uname, pwd);
		if(u!=null){
			logger.debug(uname+"登录成功");
		}else{
			logger.debug(uname+"登录失败");
		}
		return u;
	}
	@Override
	public int userChangePwdService(String newPwd, int uid) {
		logger.debug(uid+":发起密码请求");
		int index=ud.userChangePwdDao(newPwd,uid);
		if(index>0){
			logger.debug(uid+":密码修改成功");
		}else{
			logger.debug(uid+":密码修改失败");
		}
		return index;
	}
	@Override
	public List<User> userShowService() {
		List<User> lu=ud.userShowDao();
		logger.debug("显示所有用户信息："+lu);
		return lu;
	}
		@Override
		public int userRegService(User u) {
			return ud.userRegDao(u);
		}
		
		//校验Cookie信息
		@Override
		public User checkUidService(String uid) {
			return ud.checkUidDao(uid);
		}
	
}
