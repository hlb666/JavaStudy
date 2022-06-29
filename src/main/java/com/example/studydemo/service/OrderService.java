package com.example.studydemo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.studydemo.domain.Order;

import java.util.List;

public interface OrderService {


    List<Order> getAllOrder(IPage objectPage);
}
