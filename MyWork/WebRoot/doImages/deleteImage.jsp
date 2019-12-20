<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'deleteImage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	

  </head>
  
  <body class="add-body">
  
  
  	<div class="left-top"  style="width:100%;position:fixed;">
    <li style="margin-left:10px;font-size:18px;">位置：<a style="color:silver;">图片管理>图片删除</a></li>  
    </div>
  	<div style="padding:20px;overflow:hidden;">
  	<div  class="add-form">
    <form name="simpleform" action="img" method="POST">
    <input type="hidden" name="oper2" value="delete" />
    	<a style="color:black;">您要删除的图片是：</a><input type="text" name="acquisition_time" placeholder="请输入图片名称">
    	<input type="submit" value="确定删除">
    </form>
 </div>
 </div>
  </body>
</html>
