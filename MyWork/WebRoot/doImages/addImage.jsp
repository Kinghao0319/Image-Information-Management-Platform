<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">

    <title>addImage</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/styles.css">
  </head>

  <body class="add-body">
  	<div class="left-top"  style="width:100%;position:fixed;">
    <li style="margin-left:10px;font-size:18px;">位置：<a style="color:silver;">图片管理>图片上传</a></li>  
    </div>
    <div style="padding:20px;overflow:hidden;">
    <form class="add-form" name="simpleform" action="img?oper2=add" method="POST" enctype="multipart/form-data">
    <input type="hidden" name="oper2" value="add" />
	 <table border="1" style="border-radius: 5px; width:400px;cellspacing:1px">
                
                <tr>
                    <td class="label">国家</td>
                    <td class="controler"><input type="text" name="country" placeholder="中国"></td>

                </tr>

                <tr>
                    <td class="label">位置</td>
                    <td class="controler">
                    <select name="position">
                      
					  <option value ="east" selected="selected">东部</option>
					  <option value ="west">西部</option>
					  <option value ="south">南部</option>
					  <option value ="north">北部</option>
					</select>
                	</td>
                </tr>
                <tr>
                    <td class="label">分辨率</td>
                    <td class="controler"><input type="text" name="resolution" placeholder="5000"></td>
                </tr>
                <tr>
                    <td class="label">经度</td>
                    <td class="controler"><input type="text" name="longitude" placeholder="30E"></td>
                </tr>
                <tr>
                    <td class="label">纬度</td>
                    <td class="controler"><input type="text" name="latitude" placeholder="40W"></td>
                </tr>
                
                <tr>
                    <td class="label">比例尺</td>
                    <td class="controler"><input type="text" name="scale" placeholder="200"></td>
                </tr>
                <tr>
                    <td class="label">上传图片</td>
                    <td class="controler"><input type="file" name="Resume" />
                    </td>
                </tr>
                <tr>
                    <td class="label"></td>
                    <td class="controler"><button type="submit">ok</button>
                    </td>
                </tr>
		</table>
	</form>
	</div>
  </body>
</html>
