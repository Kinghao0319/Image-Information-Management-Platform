<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>">
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>signup</title>
    <link rel="stylesheet" href="css/styles.css">
    <script src="js/signup.js"></script>
  </head>
<body style="background: url('img/0.jpeg') no-repeat center;background-size:cover;">
    <div class="login-wrap">


    <div class="login-html">
      <label class="sign-up tab">SIGN UP</label>



      <form class="login-form" action="user" method="post">
      	<input type="hidden" name="oper" value="reg" />

        <div class="group">
            <label for="name" class="label">Name</label>
            <input id="name" name="uname" type="text" class="input" value="" required="">
        </div>
        
        
        <div class="group">
            <label for="age" class="label">Age</label>
            <input id="age" name="age" type="text" class="input" value="">
        </div>
        
        <div class="group">
            <label for="birth" class="label">Birth</label>
            <input id="birth" name="birth" type="text" class="input" value="">
        </div>
        
        
        
        <div class="group">
            <label id="lmale"for="male" class="button" style="width:50%;float:left;border-radius: .5rem;" onclick="document.getElementById('lfemale').style.backgroundColor='rgba(255,255,255,.1)';
          document.getElementById('lmale').style.backgroundColor='black';
        	style.backgroundColor='black';">MALE</label>
        	<label id="lfemale"for="female" class="button"style="width:50%;float:left;border-radius: .5rem;" onclick="document.getElementById('lmale').style.backgroundColor='rgba(255,255,255,.1)';
        	style.backgroundColor='black';">FEMALE</label>
        	<input id="male"type="radio" name="sex" value="1" checked="checked"/>
        	<input id="female"type="radio" name="sex" value="2" />
        </div>

        <div class="group">
            <label for="password" class="label" id="passwordLabel">Password</label>
            <input id="password" name="pwd" type="password" class="input" data-type="password" required="" minlength="6">
        </div>


        <div class="group">
            <label for="password-confirm" class="label">Repeat Password</label>
            <input id="password-confirm" name="password-confirm" type="password" class="input" data-type="password" required="" minlength="6" onblur="checkPasswd();">
        </div>
        <div id="repeat-passwd-notice"style="display:none;height:20px;width:200px;color:red;font-size:15px;">
            请输入相同的密码！
        </div>
            
        
              
        <div class="group">
            <input type="submit" class="button" value="Sign Up">
        </div>
      </form>
    </div>

    </div>
  </body>
</html>
