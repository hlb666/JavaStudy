package com.example.studydemo.service.impl;


import com.example.studydemo.common.core.domain.AjaxResult;
import com.example.studydemo.domain.User;
import com.example.studydemo.repository.mapper.UserMapper;
import com.example.studydemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public int deleteUser(Integer id) {
        int i = userMapper.deleteById(id);
        return i;
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public AjaxResult serviceException() {
        int a = 0;
        int b = 1;
        int result = b / a;

        return AjaxResult.success(result);
    }

}
