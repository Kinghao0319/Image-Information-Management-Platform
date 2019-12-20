<%@ page language="java" import="java.util.*,com.yhh.pojo.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎登录后台管理系统</title>
<link href="css/styles.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>

<!-- <script src="js/cloud.js" type="text/javascript"></script> -->
<link rel="stylesheet" href="./css/styles.css"/>
<script src="js/signin.js"></script>
<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })
});
</script>

</head>

<body style="background: url('img/1.jpeg') no-repeat center;background-size:cover;">



    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>


<div class="login-wrap">



    <div class="login-html">

			
			

    <span class="systemlogo"></span>
    <br />
    <%
    	//声明java代码块进行错误提示语的逻辑校验
    	Object obj=request.getAttribute("flag");
    	if(obj!=null){
    %>
	    <div style="text-align: center;">
	     <span style="font-size: 15px;color:darkred;font-weight: bold;">用户名或者密码错误</span>
	    </div>
    <%} %>
   <%
    	//声明java代码块进行密码修改提示语
    	Object pwd=session.getAttribute("pwd");
    	if(pwd!=null){
    %>
	    <div style="text-align: center;">
	     <span style="font-size: 15px;color:darkred;font-weight: bold;">密码修改成功</span>
	    </div>
    <%}
    	session.removeAttribute("pwd");
    %>
       <%
    	//声明java代码块进行注册提示语
    	Object reg=session.getAttribute("reg");
    	if(reg!=null){
    %>
	    <div style="text-align: center;">
	     <span style="font-size: 15px;color:darkred;font-weight: bold;">注册成功</span>
	    </div>
    <%}
    	session.removeAttribute("reg");
    %>



    <form action="user" method="post"  class="login-form">
    	<input type="hidden" name="oper" value="login" />
    	<span class="sign-up tab" style="width:150%;font-weight:bold;font-size:32px">&nbsp;&nbsp;欢迎登录图片信息管理系统</span>
    	<ul>

			<div class="group">
					<label for="name" class="label">Name</label>
					<input id="name" name="uname" type="text" class="input" value="" required=""  title="Name doesn&#39;t follow the pattern. Only latin letters are allowed.">
			</div>

			<div class="group">
					<label for="password" class="label" id="passwordLabel">Password</label>
					<input id="password" name="pwd" type="password" class="input" data-type="password" required=""  onblur="checkPasswd">
			</div>
			<div id="passwd-notice"style="display:none;height:20px;width:200px;color:red;font-size:5px;">
					密码和用户名不一致或用户不存在！请重新检查输入！
			</div>
			<div class="group">
					<input type="submit" class="button" value="SIGN IN">
			</div>
			
			
			
			
		
    </form>
    		<form action="user/signup.jsp" method="post"  class="login-form">
			<div class="group">
					<input type="submit" class="button" value="SIGN UP">
<!-- 				<label class="button" style="text-align: center;font-size:8pt;"><a href="user/signup.jsp">SIGN UP</a></label> -->
			</div>
			</form>
		
		
    </div>
  </div>



</body>

</html>
