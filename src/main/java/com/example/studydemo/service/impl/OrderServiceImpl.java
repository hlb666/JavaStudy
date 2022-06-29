package com.example.studydemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.studydemo.domain.Order;
import com.example.studydemo.repository.mapper.OrderMapper;
import com.example.studydemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> getAllOrder(IPage ipage) {
        IPage iPageList = orderMapper.selectPage(ipage, new QueryWrapper<>());
        System.out.println(ipage.getSize()+"-"+ipage.getCurrent());
        return iPageList.getRecords();
    }

}
