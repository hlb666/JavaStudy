package com.example.studydemo.controller;

import com.example.studydemo.common.core.controller.BaseController;
import com.example.studydemo.common.core.domain.AjaxResult;
import com.example.studydemo.domain.User;
import com.example.studydemo.common.socket.WebSocketService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/socketTestController")
public class SocketTestController extends BaseController {


    @PostMapping("/push")
    public AjaxResult push() {

        ThreadLocal<User> objectThreadLocal = new ThreadLocal<>();
        objectThreadLocal.set(new User());
        // 模拟需要推送的用户群
        User user = objectThreadLocal.get();
        ArrayList<String> ids = new ArrayList<>();
        ids.add("001");
        ids.add("002");
        ids.add("003");
        ids.add("004");
        ids.add("005");

        WebSocketService webSocketService = new WebSocketService();
        webSocketService.sendMsgToUsers(ids);

        return AjaxResult.success("推送成功");

    }
}
