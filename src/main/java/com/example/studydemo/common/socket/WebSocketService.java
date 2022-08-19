package com.example.studydemo.common.socket;

import java.util.List;

public class WebSocketService {

    // 推送给指定的在线的用户
    public void sendMsgToUsers(List<String> ids) {
        Server4WebSocket server4WebSocket = new Server4WebSocket();
        server4WebSocket.sendMsgToUsers(ids);
    }

}
