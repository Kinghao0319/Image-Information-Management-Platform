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
<link href="css/styles.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>

<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>


</head>


<body class="add-body">
      
    
    
    
    
    
    <div class="left-top"  style="width:100%;position:fixed;">
    <li style="margin-left:10px;font-size:18px;">位置：<a style="color:silver;">管理信息>查看用户信息</a>
    
    </li>  
    </div>
    <div style="padding:20px;overflow:hidden;">
    <div  class="add-form" style="width:100%;max-width:300px;">
    
    <table border="1" style="border-radius: 5px; max-width:400px;width:100%;cellspacing:1px">
    	<thead>
    	<tr>
        <th class="label">UID<i class="sort"><img src="images/px.gif" /></i></th>
        <th class="label">用户名</th>
        <th class="label">密码</th>
        <th class="label">性别</th>
        <th class="label">年龄</th>
        <th class="label">出生年月</th>
        </tr>
        </thead>
        <tbody>
        <%
        	List<User> lu=(ArrayList<User>)request.getAttribute("lu");
        	for(User u:lu){
        %>
	        <tr>
	        <td><%=u.getUid() %></td>
	        <td><%=u.getUname() %></td>
	        <td><%=u.getPwd()%></td>
	        <%
	        	if("1".equals(u.getSex())){
	        %>
	        <td>男</td>
	        <%}else{ %>
	         <td>女</td>
	        <%} %>
	        <td><%=u.getAge() %></td>
	        <td><%=u.getBirth() %></td>
	        </tr>
        <%} %> 
        </tbody>
    </table>
    
    
    
    
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</div>
</body>

</html>