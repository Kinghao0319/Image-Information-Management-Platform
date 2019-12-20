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
<title>无标题文档</title>
<style>
	body::-webkit-scrollbar {
    display: none;
}
	body {
    -ms-overflow-style: none;
/*     scrollbar-width: none; */
}
</style>	
<link href="css/styles.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="js/jquery.js"></script>

</head>


<body class="add-body">

	<div class="left-top" style="position:fixed;width:100%;">
    <li style="margin-left:10px;font-size:18px;">位置：<a style="color:silver;">个人信息>首页</a></li>  
    
    </div>
    
    <div style="padding:20px;overflow:hidden;">
    
    
    <div class="wel-info">
    <span><img src="images/sun.png" alt="天气" /></span>
    <b>Admin早上好，欢迎使用信息管理系统</b>(admin@uimaker.com)
    <a href="#">帐号设置</a>
    </div>
    <div class="ibox" style="height:5px;margin:0px;padding:0px"></div>
    
    <div class="wel-info">
    <span><img src="images/time.png" alt="时间" /></span>
    <i>欢迎<a style="color:orange;margin:0;padding:0"><%=((User)session.getAttribute("user")).getUname()%></a>登陆系统，</i> 
    	<%
        	if(((User)session.getAttribute("user")).getUid()==0){
        %>
        <i>您是<a style="color:orange;margin:0;padding:0">管理员</a></i>
        <%} else{%>
        <i>您是<a style="color:orange;margin:0;padding:0">普通用户</a></i>
        <%} %>
        
    </div>
    
    <div class="xline"></div>
    
    <ul class="um-list">
    
    <li><a href="user/userInfo.jsp"><img src="images/ico01.png" /></a><p><a href="user/userInfo.jsp">个人信息</a></p></li>
    <li><a href="doImages/addImage.jsp"><img src="images/ico02.png" /></a><p><a href="doImages/addImage.jsp">发布图片</a></p></li>
    <li><a href="doImages/num.jsp"><img src="images/ico03.png" /></a><p><a href="doImages/num.jsp">数据统计</a></p></li>
<!--     <li><img src="images/ico04.png" /><p><a href="#">文件上传</a></p></li> -->
<!--     <li><img src="images/ico05.png" /><p><a href="#">目录管理</a></p></li> -->
    <li><a href="doImages/watchImage.jsp"><img src="images/ico06.png" /></a><p><a href="doImages/watchImage.jsp">图片查询</a></p></li> 
            
    </ul>
    
<!--     <div class="ibox"><a class="ibtn"><img src="images/iadd.png" />添加新的快捷功能</a></div> -->
    
    <div class="ibox" style="height:0px;margin:0px;padding:0px"></div>
    
    <div class="xline"></div>
    <div class="box"></div>
    
    <div class="wel-info">
    <span><img src="images/dp.png" alt="提醒" /></span>
    <b>图片信息管理系统使用指南</b>
    </div>
    
    <ul class="info-list">
    <li><span>您可以快速进行图片发布管理操作</span><a class="ibtn" href="doImages/addImage.jsp">发布或管理图片</a></li>
    <li><span>您可以快速查询内容</span><a class="ibtn" href="doImages/watchImage.jsp">查询相关信息</a></li>
    <li><span>您可以进行密码修改、账户设置等操作</span><a class="ibtn" href="user/cpwd.jsp" target="body">密码修改</a></li>
    </ul>
    
    <div class="xline"></div>
    
    <div class="wel-info" style="margin-top:10px;">
    <span><img src="images/t04.png" alt="提醒" /></span>
    <b>查看图片信息管理网站使用指南，您可以更好的了解网站相关功能，详见</b><a href="http://www.ecnu.edu.cn" target="_blank">ecnu.com</a>
    </div>
    
    <ul class="um-list">
    <li><a href="doImages/notGiven.jsp">如何发布文章</a></li>
    <li><a href="doImages/notGiven.jsp">如何访问网站</a></li>
    <li><a href="doImages/notGiven.jsp">如何管理广告</a></li>
    <li><a href="user/showUser.jsp">后台用户查看(权限)</a></li>
    <li><a href="doImages/notGiven.jsp">系统设置</a></li>
    </ul>
    
    
    </div>
    
    

</body>

</html>
