package com.example.studydemo.common.notify.listener;

import com.example.studydemo.common.notify.event.DeleteUser;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class DeleteListener implements ApplicationListener<DeleteUser> {


    @Override
    public void onApplicationEvent(@NotNull DeleteUser user) {
        System.out.println("收到消息：用户已经删除"+user.getSource().toString());
    }
}
