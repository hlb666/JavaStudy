package com.example.studydemo.repository.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.studydemo.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
