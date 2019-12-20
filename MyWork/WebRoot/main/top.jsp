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
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/styles.css" rel="stylesheet" type="text/css" />
<link href="css/mainpage.css" rel="stylesheet" type="text/css" />

<script language="JavaScript" src="js/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})
	//退出功能
	$("#out").click(function(){
		var flag=window.confirm("你真的要退出吗?");
		if(flag){
			window.top.location.href="user?oper=out";
		}
	})
	
	
})	
</script>


</head>

<body style="background-color:rgba(0,0,0,.8);height:50px;">

   	
	<img src="img/th.png" alt="nerv" height="80"  width="80" style="margin-left:50px;margin-top:10px;">
	<img src="img/header.png" height="80" style="margin-left:20px;margin-top:20px;">
    <button onclick="$()" style="border-radius:.5rem;background-color:rgba(255,10,10,0.3);margin-top:15px;border-width:0;float:right;height:50px;line-height:50px;width:100px;color:white;font-size:18px;"id="out">
    	退出
    </button>
    
    
     
    <div  style="border-radius:.5rem;background-color:rgba(255,10,10,0.3);margin:15px 15px;float:right;height:50px;line-height:50px;width:auto;color:white;font-size:18px;">
    	
    	<span style="width:100%;line-height:50px; height:50px;margin:0 auto;"><img src="images/visitor.png"height="20" width="20"> </img><a href="user/userInfo.jsp" target="rightFrame" style="font-size:18px;color:white;"><%=((User)session.getAttribute("user")).getUname()%><a></a></span>
    </div>    
    
    </div>

</body>
</html>



