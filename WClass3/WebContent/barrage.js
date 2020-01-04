   
    var websocket = null;
    var id = "3500012019-2020(1)120001";
    var target = "ws://47.101.144.217:8080/WisdomClass_java/websocket/"+id;
        if('WebSocket' in window) {
            websocket = new WebSocket(target); 
        } else if('MozWebSocket' in window) {
            websocket = MozWebSocket(target);
        } else {
            window.alert("浏览器不支持WebSocket");
        }
                 
      //连接发生错误的回调方法
             websocket.onerror = function() {
                 setMessageInnerHTML("WebSocket连接发生错误");
             };
         
             //连接成功建立的回调方法
             websocket.onopen = function() {
                 setMessageInnerHTML("欢迎进入聊天室");
             }
        
             //接收到消息的回调方法
             websocket.onmessage = function(event) {
                 setMessageInnerHTML(event.data);
             }
         
             //连接关闭的回调方法
             websocket.onclose = function() {
                 setMessageInnerHTML("WebSocket连接关闭");
             }       
             //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
                  window.onbeforeunload = function() {
                      closeWebSocket();
                  }
             //将消息显示在网页上
             function setMessageInnerHTML(innerHTML) {
            	 var m =  document.getElementById('message');         
            		if(innerHTML=="closing"){
            			m.innerHTML = "已禁言"+'<br/>';
            		}else if(innerHTML=="opening"){
            			m.innerHTML = "已恢复"+'<br/>';
            		}
            			else{ m.innerHTML += innerHTML + '<br/>';}
            	                       
             }
         
             //关闭WebSocket连接
             function closeWebSocket() {
                 websocket.close();
             }
         
             //发送消息
             function send() {
                 var message = document.getElementById('text').value;
                 websocket.send(message);
   	          }
             function sendopen() {
                 var message = "opening";
                 websocket.send(message);
   	          }
             function sendclose() {
                 var message = "closing";
                 websocket.send(message);
   	          }