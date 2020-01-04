<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>随机点名</title>
   <meta name="description" content="particles.js is a lightweight JavaScript library for creating particles.">
  <meta name="author" content="Vincent Garreau" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <link rel="stylesheet" media="screen" href="LoginCss/css/style.css">
  <link rel="stylesheet" type="text/css" href="LoginCss/css/reset.css"/>
</head>
<body>
<div id="particles-js">
	<div class="login">
	<form action="pick" method="post">
	
	<div style="text-align: center;">
       <input type="submit" style="cursor: pointer;text-align:center;line-height: 40px;
       width: 245px;height: 50px;border-radius: 5px;margin:0 auto;margin-top: 40px;
       color:white;background-color: dodgerblue;" value="开始点人">			 		
     </div></form>
     	<a href="t_index.jsp" style="display: block; text-align: center;font-size:20px;"><button>返回</button></a>
     </div>
     	<div class="sk-rotating-plane"></div>
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