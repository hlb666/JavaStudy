package com.example.studydemo.controller;


import com.example.studydemo.common.core.domain.AjaxResult;
import com.example.studydemo.mq.config.RabbitMQConfig;
import com.example.studydemo.mq.consumer.TestConsumer;
import com.example.studydemo.mq.provider.TestProvider;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/rabbitmq")
public class RabbitMqTestController {
    @Autowired
    private TestProvider testProvider;



    // 生产者
    @PostMapping("/provider")
    public AjaxResult testProvider(@RequestParam("msg") String msg) throws Exception{

        testProvider.sendMsg(msg);

        return AjaxResult.success();
    }



    // 消费者定义






}
