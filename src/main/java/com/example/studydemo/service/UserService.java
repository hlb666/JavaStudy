package com.example.studydemo.service;

import com.example.studydemo.common.core.domain.AjaxResult;
import com.example.studydemo.domain.User;

public interface UserService {
    int deleteUser(Integer id);

    User getUserById(Integer id);


    AjaxResult serviceException();
}
