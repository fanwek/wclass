<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Charles-WebSocket</title>

<script src="barrage.js"></script>
</head>
<body>

    Welcome<br/><input id="text" type="text"/>
      <button onclick="send()">发送消息</button>
     <hr/>
     <button onclick="sendopen()">开启弹幕功能</button>
     <button onclick="sendclose()">关闭弹幕功能</button>
     <hr/>
    <div id="message"></div>
</body>
</html>