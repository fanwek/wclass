<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师主界面</title>
  <meta name="description" content="particles.js is a lightweight JavaScript library for creating particles.">
  <meta name="author" content="Vincent Garreau" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <link rel="stylesheet" media="screen" href="LoginCss/css/style.css">
  <link rel="stylesheet" type="text/css" href="LoginCss/css/reset.css"/>
</head>
<body>
<div id="particles-js">
<div class="login">
  <div>
  <br>
  <h1 align="center"><font size="8" face="arial" color="dodgerblue">welcome</font></h1>
  </div>
  <div>
    <ul>
       <li><br><br><br><br><br></li>
      <li> <a href="pick.jsp" style="display: block;text-align: center;font-size:20px;color:dodgerblue;">发起点名</a> </li>
      <li><br><br><br></li>
      <li> <a href="barrage.jsp" style="display: block;text-align: center;font-size:20px;color:dodgerblue;">弹幕功能</a> </li>
      <li><br><br><br><br><br><br><br><br></li>
      <li><a href="login.jsp" style="display: block; text-align: center;font-size:20px;">返回登录界面</a></li>
    </ul>
  </div>
  <div class="sk-rotating-plane"></div>
  </div>
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