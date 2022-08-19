package com.example.studydemo.controller;


import com.example.studydemo.common.core.domain.AjaxResult;
import com.example.studydemo.common.mq.provider.TestProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
