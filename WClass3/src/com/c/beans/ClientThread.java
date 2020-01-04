/*
 * 编写人：黄钶炳
 * 类的功能：用于实时弹幕与服务端的交互
 */
package com.example.wisdomclass.Util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;


import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import okhttp3.WebSocket;

public class ClientThread implements Runnable {
    private String id;//课程id
    private URI uri;//服务端地址
    private WebSocketClient client;
    // 定义向UI线程发送消息的Handler对象
    private Handler handler;
    // 定义接收UI线程的消息的Handler对象
    public Handler revHandler;

    public ClientThread(Handler handler,String id) {
        this.handler = handler;
        this.id = id;
        uri = URI.create("ws://47.101.144.217:8080/WisdomClass_java/websocket/"+id);
    }

    public void run() {
        try {
            client = new WebSocketClient(uri) {
                @Override
                public void onOpen(ServerHandshake handshakedata) {

                }

                @Override
                public void onMessage(String message) {//收到消息时 对于消息简要分析 并传回talkFragment
                    String mess = message.trim();
                    if(mess.equals("closing")){
                        Message msg = new Message();
                        msg.what = 0x789;
                        msg.obj = message;
                        handler.sendMessage(msg);
                    }
                    else if(mess.equals("opening")){
                        Message msg = new Message();
                        msg.what = 0x779;
                        msg.obj = message;
                        handler.sendMessage(msg);
                    }
                    else{
                        Message msg = new Message();
                        msg.what = 0x123;
                        msg.obj = message;
                        handler.sendMessage(msg);
                    }
                }

                @Override
                public void onClose(int code, String reason, boolean remote) {

                }

                @Override
                public void onError(Exception ex) {

                }
            };
            client.connect();
            // 为当前线程初始化Looper
            Looper.prepare();
            // 创建revHandler对象
            revHandler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    // 接收到UI线程中用户输入的数据
                    if (msg.what == 0x234) {
                        // 将用户在文本框内输入的内容写入网络
                        try {
                            System.out.println(client.isOpen());
                            client.send(msg.obj.toString());
                            //client.send((msg.obj.toString() + "\r\n").getBytes("utf-8"));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            // 启动Looper
            Looper.loop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void distory(){
        client.close();
    }

}
