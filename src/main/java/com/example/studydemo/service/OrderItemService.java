package com.example.studydemo.service;



import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.studydemo.domain.Order;
import com.example.studydemo.domain.OrderItem;

import java.util.List;

public interface OrderItemService {
    public List<OrderItem> getAllOrderItem();

    List<OrderItem> getOrderItemByCondition(OrderItem orderItem);

    int addOrderItem(OrderItem orderItem);

    int updataOrderItem(OrderItem orderItem);

    int delOrderItem(List<String> orderNum);
}
