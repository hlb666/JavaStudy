package com.example.studydemo.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.studydemo.domain.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
