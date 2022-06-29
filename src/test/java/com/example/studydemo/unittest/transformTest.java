package com.example.studydemo.unittest;

import com.example.studydemo.common.utils.Transform;
import com.example.studydemo.domain.Order;
import com.example.studydemo.domain.OrderDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class transformTest {

    @Test
    void transferToDomainDo() {

        OrderDTO orderDto = new OrderDTO();
        orderDto.setOrderNum("001");
        orderDto.setCustId("110");
        orderDto.setPhone("11111");
        Transform transform = new Transform();
       Order order =  transform.transferToDomainDo(orderDto, Order.class);
        System.out.println(order.toString());



    }
}