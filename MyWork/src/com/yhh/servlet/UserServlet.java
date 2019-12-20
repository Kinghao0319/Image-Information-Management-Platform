package com.yhh.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.yhh.pojo.User;
import com.yhh.service.UserService;
import com.yhh.service.impl.UserServiceImpl;

public class UserServlet extends HttpServlet {
	
	Logger logger =Logger.getLogger(UserServlet.class);
	
	UserService us=new UserServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String oper=req.getParameter("oper");
		if("login".equals(oper)){
			checkUserLogin(req,resp);
		}else if("out".equals(oper)){
			userOut(req,resp);
		}else if("pwd".equals(oper)){
			userChangePwd(req,resp);	
		}else if("show".equals(oper)){
			userShow(req,resp);
		}else if("reg".equals(oper)){
			userReg(req,resp);
		}else{
			logger.debug("没有找到对应的操作符："+oper);
		}
	}
	private void userReg(HttpServletRequest req, HttpServletResponse resp) throws IOException {
			String uname=req.getParameter("uname");
			String pwd=req.getParameter("pwd");
			String sex=req.getParameter("sex");
			int age=req.getParameter("age")!=""?Integer.parseInt(req.getParameter("age")):0;
			String birth=req.getParameter("birth");
//			String[] bs=null;
//			if(birth!=""){
//				bs=birth.split("/");
//				birth=bs[2]+"-"+bs[0]+"-"+bs[1];
//			}
			System.out.println(uname+":"+pwd+":"+sex+":"+age+":"+birth);
			User u=new User(0, uname, pwd, sex, age, birth);
			int index=us.userRegService(u);
			if(index>0){
				HttpSession hs=req.getSession();
				hs.setAttribute("reg", "true");
				resp.sendRedirect("./login.jsp");
			}
		
	}
	private void userShow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			List<User> lu=us.userShowService();
			if(lu!=null){
				req.setAttribute("lu",lu);
				req.getRequestDispatcher("/user/showUser.jsp").forward(req, resp);
				return;
			}
		
	}
	private void userChangePwd(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
			String newPwd=req.getParameter("newPwd");
			User u=(User)req.getSession().getAttribute("user");
			int uid=u.getUid();
			int index=us.userChangePwdService(newPwd,uid);
			if(index>0){
				HttpSession hs=req.getSession();
				hs.setAttribute("pwd","true");
				resp.sendRedirect("login.jsp");
				//req.getRequestDispatcher("/my/login.jsp").forward(req, resp);
			}
	}
	private void userOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession hs=req.getSession();
		hs.invalidate();
		resp.sendRedirect("./login.jsp");
	}
	private void checkUserLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
				String uname=req.getParameter("uname");
				String pwd=req.getParameter("pwd");
					User u=us.checkUserLoginService(uname, pwd);
					if(u!=null){
						Cookie c= new Cookie("uid",u.getUid()+"");//创建cookie
						c.setMaxAge(3600);//一小时免登陆
						c.setPath("./cookie");
						//添加cookie信息
						resp.addCookie(c);
						ServletContext sc=this.getServletContext();
						if(sc.getAttribute("nums")!=null){
							int nums=(int)sc.getAttribute("nums");
							//计数器自增
							nums+=1;
							//再次存储到ServletContext对象中
							sc.setAttribute("nums", nums);
						}else{
							sc.setAttribute("nums", 1);
						}
						
						HttpSession hs=req.getSession();
						hs.setAttribute("user", u);
						resp.sendRedirect("./main/main.jsp");
						return;
					}else{
						req.setAttribute("flag",0);
						req.getRequestDispatcher("/login.jsp").forward(req, resp);
						return;
					}
					
					
	}
	
	
}
