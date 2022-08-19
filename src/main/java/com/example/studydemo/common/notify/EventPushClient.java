package com.example.studydemo.common.notify;

import com.example.studydemo.common.notify.event.DeleteUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;


@Component
public class EventPushClient {

    @Autowired
    ApplicationContext applicationContext;

    public void sendEvent(DeleteUser deleteUser) {
        applicationContext.publishEvent(deleteUser);
    }
}
