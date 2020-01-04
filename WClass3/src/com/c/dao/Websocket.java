package com.c.dao;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
@ServerEndpoint("/websocket/{ID}")
public class Websocket {
	private String id = null;
	private static CopyOnWriteArraySet<Websocket> webSocketSet = new CopyOnWriteArraySet<>();
	private static CopyOnWriteArraySet<String> close = new CopyOnWriteArraySet<>();
	private Session session;
	@OnOpen
	public void onOpen(@PathParam(value = "ID") String param,Session session) {
		this.id = param;
		//System.out.print(id);
		this.session = session;
		webSocketSet.add(this);     //����set��
		try {
			if(close.contains(this.id)){
				session.getBasicRemote().sendText("closing");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@OnClose
	public void onClose(Session session) {
		webSocketSet.remove(this);  //��set��ɾ��
	}
	@OnError
	public void onError(Session session, Throwable error) {
		try {
			webSocketSet.remove(this);
			System.out.println(error.getMessage());
		}catch (Exception e){
			error.printStackTrace();
		}
	}
	
	@OnMessage
	public void onMessage(String message , Session session) {
		try {
			if(message.trim().equals("closing")){
				close.add(this.id);
			}
			else if(message.trim().equals("opening")){
				close.remove(this.id);
			}
			else if(message.trim().equals("")){}
			else{
				Iterator<Websocket> it = webSocketSet.iterator();
				while (it.hasNext()){
		            Websocket web = it.next();
		            if(web.id.equals(this.id)){
		            	web.session.getBasicRemote().sendText(message);
		            }
		        }
			}
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}
