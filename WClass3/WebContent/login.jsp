<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
  <title>浙江工业大学</title>
  <meta name="description" content="particles.js is a lightweight JavaScript library for creating particles.">
  <meta name="author" content="Vincent Garreau" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <link rel="stylesheet" media="screen" href="LoginCss/css/style.css">
  <link rel="stylesheet" type="text/css" href="LoginCss/css/reset.css"/>
  <script type="text/javascript">
  	 function clearLoginMsg(){
    	var spanEle = document.getElementById("login_span");
    	var spanEle1 = document.getElementById("user");
    	spanEle1.placeholder="";
    	spanEle.innerHTML="";
    } 
    </script>
</head>
<body>
<div id="particles-js">
 <form action="login" method="post">
		<div class="login">
			<div class="login-top">
				登录
			</div>
			<div class="login-center clearfix">
				<div class="login-center-img"><img src="LoginCss/img/name.png"/></div>
				<div class="login-center-input">
					<input id="user" type="text" name="username" value=""   onfocus="clearLoginMsg();" onblur="this.placeholder='请输入您的用户名'"/>
					  <span id="login_span">${requestScope.login_msg}</span>
					  <div class="login-center-input-text">用户名</div>
				</div>
			</div>
			<div class="login-center clearfix">
				<div class="login-center-img"><img src="LoginCss/img/password.png"/></div>
				<div class="login-center-input">
					<input type="password" name="password" value=""  onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的密码'"/>
					<div class="login-center-input-text">密码</div>
				</div>
			</div>
			<div style="text-align: center;">
			    <input type="submit" class="login-button" value="登录">	
			    </div>	 
		</div>
		<div class="sk-rotating-plane"></div>
		 </form>
</div>

<!-- scripts -->
<script src="LoginCss/js/particles.min.js"></script>
<script src="LoginCss/js/app.js"></script>
<script type="text/javascript">
	function hasClass(elem, cls) {
	  cls = cls || '';
	  if (cls.replace(/\s/g, '').length == 0) return false; //当cls没有参数时，返回false
	  return new RegExp(' ' + cls + ' ').test(' ' + elem.className + ' ');
	}
	 
	function addClass(ele, cls) {
	  if (!hasClass(ele, cls)) {
	    ele.className = ele.className == '' ? cls : ele.className + ' ' + cls;
	  }
	}
	 
	function removeClass(ele, cls) {
	  if (hasClass(ele, cls)) {
	    var newClass = ' ' + ele.className.replace(/[\t\r\n]/g, '') + ' ';
	    while (newClass.indexOf(' ' + cls + ' ') >= 0) {
	      newClass = newClass.replace(' ' + cls + ' ', ' ');
	    }
	    ele.className = newClass.replace(/^\s+|\s+$/g, '');
	  }
	} 
</script>
</body>
</html>