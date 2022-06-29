package com.example.studydemo.notify.event;


import com.example.studydemo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;

public class DeleteUser extends ApplicationEvent {

    @Autowired
    private User user;


    public DeleteUser(User user ) {
        super(user);
        this.user = user;
    }
}
