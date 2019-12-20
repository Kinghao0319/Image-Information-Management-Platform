<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML >
<html>
  <head>
    <base href="<%=basePath%>">

    <title>watchImage</title>
	<meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/styles.css">

  </head>
  <body class="add-body">
  	
    
    <div class="left-top" style="width:100%;position:fixed;">
    <li style="margin-left:10px;font-size:18px;">位置：<a style="color:silver;">图片管理>图片信息修改</a></li>  
    </div>
  <div style="padding:20px;overflow:hidden;">
    <form  class="add-form"name="simpleform" action="img" method="POST">
    <input type="hidden" name="oper2" value="update" />
	 <table border="1" style="border-radius: 5px; width:500px;cellspacing:1px">
                <tr>
                    <td class="label">图片名称</td>
                    <td class="controler"><input type="text" name="acquisition_time" placeholder="请填写要修改的图片名称"/></td>
                </tr>
                <tr>
                    <td class="label">国家</td>
                    <td class="controler"><input type="text" name="country" placeholder="以下各项填修改值" ></td>

                </tr>

                <tr>
                    <td class="label">位置</td>
                    <td class="controler">
                    <select name="position">
					  <option value ="east" selected="selected">东部</option>
					  <option value ="west">西部</option>
					  <option value ="south">南部</option>
					  <option value ="north">北部</option>
					</select>
                	</td>
                </tr>
                <tr>
                    <td class="label">分辨率</td>
                    <td class="controler"><input type="text" name="resolution" ></td>
                </tr>
                <tr>
                    <td class="label">经度</td>
                    <td class="controler"><input type="text" name="longitude" ></td>
                </tr>
                <tr>
                    <td class="label">纬度</td>
                    <td class="controler"><input type="text" name="latitude" ></td>
                </tr>
                
                <tr>
                    <td class="label">比例尺</td>
                    <td class="controler"><input type="text" name="scale" ></td>
                </tr>

                <tr>
                    <td class="label"></td>
                    <td class="controler"><button type="submit">确认修改</button>
                    </td>
                </tr>
		</table>
	</form>
	</div>
  </body>
</html>
