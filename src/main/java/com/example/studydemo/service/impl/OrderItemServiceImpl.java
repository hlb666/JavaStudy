package com.example.studydemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.studydemo.common.utils.StringUtils;
import com.example.studydemo.domain.Order;
import com.example.studydemo.domain.OrderItem;
import com.example.studydemo.repository.mapper.OrderItemMapper;
import com.example.studydemo.repository.mapper.OrderMapper;
import com.example.studydemo.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemMapper orderItemMapper;



    @Override
    public List<OrderItem> getAllOrderItem() {
        List<OrderItem> orderItems = orderItemMapper.selectList(new QueryWrapper<>());

        return orderItems;
    }



    @Override
    public List<OrderItem> getOrderItemByCondition(OrderItem orderItem) {
        QueryWrapper<OrderItem> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq(StringUtils.isNotBlank(orderItem.getOrderNum()),"order_num", orderItem.getOrderNum());
        queryWrapper.eq(null!=orderItem.getItemPrice(),"item_price", orderItem.getItemPrice());
        queryWrapper.eq(null!=orderItem.getQuantity(),"quantity", orderItem.getQuantity());
        List<OrderItem> orderItem1 = orderItemMapper.selectList(queryWrapper);

        return orderItem1;
    }

    @Override
    public int addOrderItem(OrderItem orderItem) {
        int insert = orderItemMapper.insert(orderItem);
        return insert;
    }

    @Override
    public int updataOrderItem(OrderItem orderItem) {
        QueryWrapper<OrderItem> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_num", orderItem.getOrderNum());
        int update = orderItemMapper.update(orderItem, queryWrapper);
        return update;
    }

    @Override
    public int delOrderItem(List<String> orderNum) {

        int i = orderItemMapper.deleteBatchIds(orderNum);
        return i;
    }


}
