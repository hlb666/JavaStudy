package com.example.studydemo.common.socket;


import com.alibaba.druid.support.json.JSONUtils;
import com.rabbitmq.tools.json.JSONUtil;
import io.netty.handler.codec.json.JsonObjectDecoder;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

@Component
@ServerEndpoint(value = "/serverForWebSocket/{userId}")
public class Server4WebSocket {


    // 存储登录用户的 sid 以及 session
    private static ConcurrentHashMap<String, Session> connections = new ConcurrentHashMap<>(32);


    private Session session; // 是WebSocket的Session

    // 统计在线人数
    private static AtomicInteger onlineCount = new AtomicInteger();
    @OnOpen //事件 --登录的人.//当你登录之后建立连接，此方法便会执行
    public void onopen(@PathParam("userId") String  userId, Session session) {
        this.session = session;
        System.out.println("seesionId为" + session.getId());
        if (connections.containsKey(userId)) {
            connections.remove(userId);
            connections.put(userId, session);
        }else {
            onlineCount.incrementAndGet();
            connections.put(userId, session);
            System.out.println("用户："+userId+"-"+session.getId()+"上线了-"+session);
            System.out.println("在线人数："+onlineCount);

        }
        String content = new JSONObject(connections).toString();
        System.out.println("在线用户信息：" + content);

    }

    @OnClose
    public void onClose(Session session){
        for (String userId : connections.keySet()) {
            if(connections.get(userId).equals(session)){
                System.out.println("用户："+userId+"-关闭-"+session);
                connections.remove(session);
                onlineCount.decrementAndGet(); // 在线数减1
            }
        }
    }

    @OnMessage
    public void onMessage(String msg, Session session) {
        System.out.println("服务端收到客户端"+session.getId()+"的消息:"+msg);
        // 客户端向服务端发送消息，然后再推送给其他的用户，可以在这里进行设置
        try {
            sendMessage(msg, session);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }

    //推送
    public void sendMessage(String msg, Session session) throws IOException {
//        for (Session session1 : webSocketSet) {
//            if (session != session1)
//                session1.getBasicRemote().sendText(msg);
//        }
        System.out.println("推送："+msg);
        session.getBasicRemote().sendText(msg);
//        session.getAsyncRemote().sendText(msg);
    }

    // 推送给指定的用户群
    public void sendMsgToUsers(List<String> ids) {
        ids.stream().forEach(s -> {
            System.out.println("用户："+s+"是否能够推送："+connections.containsKey(s));
            if (connections.containsKey(s)) {
                    if (connections.get(s).isOpen()){
                        try {
                            System.out.println("开始推送");
                            sendMessage("hello:"+s,connections.get(s));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
            }
        });
    }

    // 推送给全部在线用户
    public void sendMsgToAll(){
        connections.keySet().stream().forEach(s->{
            if (connections.get(s).isOpen()){
                try {
                    System.out.println("开始推送");
                    sendMessage("hello:"+s,connections.get(s));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

}
