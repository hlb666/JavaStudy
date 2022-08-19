package com.example.studydemo.unittest;

import com.example.studydemo.common.utils.Transform;
import com.example.studydemo.domain.Order;
import com.example.studydemo.domain.OrderDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.input.LineSeparatorDetector;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

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

    public void threadTest() {

        // 创建线程池
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();

    }

    @Test
    public void re(){
        List<Integer> taskIds = new ArrayList<>();
        taskIds.add(1);
        taskIds.add(2);
        taskIds.add(3);
        taskIds.add(4);

        List<Integer> tempTaskIds = new ArrayList<>();
        List<List<Integer>> statusBeanList = new ArrayList<>();

        for (Integer taskId : taskIds) {
            tempTaskIds.add(taskId);
            if (tempTaskIds.size() == 2) {
                statusBeanList.add(tempTaskIds);
                tempTaskIds = null;
            }
        }
        if (!tempTaskIds.isEmpty()) {
            statusBeanList.add(tempTaskIds);
        }

        System.out.println(statusBeanList.get(1));




    }



}