package com.example.studydemo.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.studydemo.common.core.controller.BaseController;
import com.example.studydemo.common.core.domain.AjaxResult;
import com.example.studydemo.common.core.page.Page;
import com.example.studydemo.domain.Order;
import com.example.studydemo.domain.OrderItem;
import com.example.studydemo.service.OrderItemService;

import com.example.studydemo.service.OrderService;
import com.github.pagehelper.PageHelper;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@RestController
@RequestMapping("/puls/basemapper")
public class MybaitsPulsTestController extends BaseController {

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private OrderService orderService;

// =====================分页查询============================================

    // 使用mybatis-puls 查询 pageHelper 分页
    @PostMapping("/getAllOrderItem")
    public AjaxResult getAllOrderItem(@RequestBody Page page){
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<OrderItem> allOrderItem = orderItemService.getAllOrderItem();
        return AjaxResult.successPage(allOrderItem);
    }


    // 使用mybaits-puls插件进行分页
    @PostMapping("/getAllOrder")
    public AjaxResult getAllOrder(@RequestBody Page page){

        System.out.println(page.getPageNo()+"-"+page.getPageNum());
        IPage<Object> objectPage = new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>(page.getPageNum(),page.getPageSize());
        List<Order> allOrderItem = orderService.getAllOrder(objectPage);
        return AjaxResult.successPage(allOrderItem);
    }

// =====================入参条件============================================

    // 按照条件查询
    @PostMapping("/getOrderItemByCondition")
    public AjaxResult getOrderItemByCondition(@RequestBody  OrderItem orderItem){
        List<OrderItem> orderItems = orderItemService.getOrderItemByCondition(orderItem);
        return  AjaxResult.success(orderItems);

    }

    // 新增
    @PostMapping("/addOrderItem")
    public AjaxResult addOrderItem(@RequestBody  OrderItem orderItem){
        int rows = orderItemService.addOrderItem(orderItem);
        return toAjax(rows);
    }


    //更新
    @PostMapping("/updataOrderItem")
    public AjaxResult updataOrderItem(@RequestBody  OrderItem orderItem){
        int rows = orderItemService.updataOrderItem(orderItem);
        return toAjax(rows);
    }

    // 删除
    @DeleteMapping("/delOrderItem")
    public AjaxResult delOrderItem(@NotNull @RequestBody Map<String, List<String>> orderNums){
        orderNums.get("orderNum").stream().forEach(s -> System.out.println(s));
        int rows = orderItemService.delOrderItem(orderNums.get("orderNum"));
        return toAjax(rows);
    }













}
