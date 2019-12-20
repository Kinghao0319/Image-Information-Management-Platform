package com.yhh.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yhh.pojo.User;

import com.yhh.service.UserService;

import com.yhh.service.impl.UserServiceImpl;

public class CookieServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置请求编码格式
			req.setCharacterEncoding("utf-8");
		//设置响应编码格式
			resp.setContentType("text/html;charset=utf-8");
		//获取请求信息
			//获取Cookie信息
			Cookie[] cks=req.getCookies();
		//处理请求信息
			if(cks!=null){
					//遍历Cookie信息
					String uid="";
					for(Cookie c:cks){
						if("uid".equals(c.getName())){//如果cookie里有叫uid的项
							uid=c.getValue();
						}
					}
					//校验UID是否存在
					if("".equals(uid)){//如果uid为空，回到登陆页面
						//请求转发
						req.getRequestDispatcher("login.jsp").forward(req, resp);
						return;
					}else{
						//校验UID用户信息
							//获取业务层对象
							UserService ls=new UserServiceImpl();
							User u=ls.checkUidService(uid);
							if(u!=null){//cookie找到了，登陆成功
								//先将用户数据放入session
								HttpSession hs=req.getSession();
								hs.setAttribute("user",u);
								//重新访问计数器+1
								int nums=(int) this.getServletContext().getAttribute("nums");
								nums+=1;
								this.getServletContext().setAttribute("nums", nums);
								//重定向，进入欢迎页面
								resp.sendRedirect("./main/main.jsp");
								return;
							}else{
								//请求转发，回到登陆
								req.getRequestDispatcher("login.jsp").forward(req, resp);
								return;
							}
					}
				
			}else{
				//响应处理结果
					//请求转发
					req.getRequestDispatcher("page").forward(req, resp);
					return;
			}
	}
}
