<%@ page language="java" import="java.util.*,com.yhh.pojo.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>">
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/styles.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="js/jquery.js"></script>
<script language="javascript">
$(function(){
	//导航切换
	$(".imglist li").click(function(){
		$(".imglist li.selected").removeClass("selected")
		$(this).addClass("selected");
	})
})

function show(name) {
	var tar=document.getElementById(name);
	tar.style.display="block";
}
function hide(name) {
	var tar=document.getElementById(name);
	tar.style.display="none";
}
</script>
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
  
  $("img").click(function(){
	 var tar = $('this').next();
	 tar.show();
  });
  
  $(".a").click(function(){
	  $(this).hide();
  })

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});


</script>
</head>


<body class="add-body">

	<div style="width:100%" scroll="auto">

    <div class="left-top"  style="width:100%;position:fixed;">
    <li style="margin-left:10px;font-size:18px;">位置：<a style="color:silver;">图片列表</a></li>
    </div>
    <div style="padding:20px;overflow:hidden;width:1500px">



    <div class="add-form" >
    <table border="2" style="border-radius: 5px; width:auto;cellspacing:1px;">

    <thead>
    <tr>
    <th class="label">缩略图</th>
	<th class="label">图片名称</th>
    <th class="label">发布人</th>
	<th class="label">国家 </th>
    <th class="label">位置</th>
    <th class="label">分辨率</th>
    <th class="label">经度</th>
    <th class="label">纬度</th>
    <th class="label">比例尺</th>
    </tr>

    </thead>

    <tbody>

			

    	<%
        	List<Image> li=(ArrayList<Image>)request.getAttribute("li");
        	for(Image img:li){
        %>
	        <tr>
	        <td><img src="myImage/<%=img.getAcquisition_time() %>" onclick="show('<%=img.getAcquisition_time() %>')"/></td>
	        <div id="<%=img.getAcquisition_time() %>" onclick="hide('<%=img.getAcquisition_time() %>')" style="top:0;left: 0;position: fixed;display:none;width:100%;height:100%;background-color:black;z-index:5500;">
				<!-- 注意这个id必须是唯一对应每一张图片，也是hide里面的参数，下面每个li里面要显示的内容可以根据需要调整-->
			<div style="width:auto;">
				<div style="max-width:560px;width:auto;margin:auto;margin-top:5%;background-color:white;">
				<img src="myImage/<%=img.getAcquisition_time() %>" style="width:560px;margin:auto;"/>
<!-- 				<div style="margin-left:50px;width:auto;"> -->
<!-- 					<li> <span class="controler" style="float:left;width:200px;margin:0;">图片ID</span><span class="controler" style="float:left;width:200px;margin:0;"><%=img.getId() %></span></li> -->
					
<!-- 					<li> <span class="controler" style="float:left;width:200px;margin:0;">发布人</span><span class="controler" style="float:left;width:200px;margin:0;"><%=img.getName() %></span></li> -->
				
<!-- 					<li> <span class="controler" style="float:left;width:200px;margin:0;">国家</span><span class="controler" style="float:left;width:200px;margin:0;"><%=img.getCountry()%></span></li> -->
					
<!-- 					<li> <span class="controler" style="float:left;width:200px;margin:0;">位置</span><span class="controler" style="float:left;width:200px;margin:0;"><%=img.getPosition()%></span></li> -->
				
<!-- 					<li> <span class="controler" style="float:left;width:200px;margin:0;">分辨率</span><span class="controler" style="float:left;width:200px;margin:0;"><%=img.getResolution()%></span></li> -->
<!-- 					<li> <span class="controler" style="float:left;width:200px;margin:0;">经度/纬度</span><span class="controler" style="float:left;width:200px;margin:0;"><%=img.getLongitude()%>/<%=img.getLatitude()%></span></li> -->
<!-- 					<li> <span class="controler" style="float:left;width:200px;margin:0;">比例尺</span><span class="controler" style="float:left;width:200px;margin:0;"><%=img.getScale()%></span></li> -->
					
					
<!-- 				</div> -->
				</div>

			</div>

			</div>
	        
			<td><%=img.getAcquisition_time() %></td>
	        <td><%=img.getName() %></td>
	        <td><%=img.getCountry()%></td>
	        <td><%=img.getPosition()%></td>
	        <td><%=img.getResolution()%></td>
	        <td><%=img.getLongitude()%></td>
	        <td><%=img.getLatitude()%></td>
	        <td><%=img.getScale()%></td>
	        
	        
	        
	        
	        
	        </tr>
        <%} %> 


    </tbody>

    </table>



    </div>




<script type="text/javascript">
	$('.imgtable tbody tr:odd').addClass('odd');
	</script>
    </div>
    
    </div>
</body>

</html>

