<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page errorPage="error.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>">
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <meta charset="UTF-8">
        <title>图片可视化管理系统</title>
        <link rel="stylesheet" href="css/start.css">
    </head>
    <body>  
        <div class="start_bg">
        <div class="start_title">
            <h1>图片信息可视化管理系统<h1></h1>
        </div>
                           <!-- <font color="white" font-size:40px>
                You might want to:
                </font>
                <a href="user/signin.jsp"><font color="white"; font-size:40px;>SIGN IN</font></a>
                <a href="user/signup.jsp"><font color="white"; font-size:40px;>SIGN UP</font></a>
            -->
                <form action="cookie" method="post"  >
    	
			
					<input type="submit" class="start_button" value="Enter">
			
			
   			 	</form>
        </div>
    </body>
</html>

