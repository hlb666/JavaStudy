package com.example.studydemo.controller;


import com.example.studydemo.common.core.controller.BaseController;
import com.example.studydemo.common.core.domain.AjaxResult;
import com.example.studydemo.domain.User;
import com.example.studydemo.common.notify.EventPushClient;
import com.example.studydemo.common.notify.event.DeleteUser;
import com.example.studydemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class EventPushTestController extends BaseController {

    @Autowired
    private UserService userService;


    @Autowired
    private EventPushClient eventPushClient;



    @PostMapping("/deleteUser")
    public AjaxResult deleteUser(@RequestParam("id") Integer id) {


        User user = userService.getUserById(id);
        int rows = userService.deleteUser(id);

        if (rows > 0) {
            System.out.println(user.toString());
            DeleteUser DeleteUser = new DeleteUser(user);
            eventPushClient.sendEvent(DeleteUser);
        }
        return toAjax(rows);
    }

}
