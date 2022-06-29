package com.example.studydemo.controller;


import com.example.studydemo.common.annotation.OperationLog;
import com.example.studydemo.common.core.controller.BaseController;
import com.example.studydemo.common.core.domain.AjaxResult;
import com.example.studydemo.common.enums.OperationLogAction;
import com.example.studydemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("/eceptionlog")
public class ExceptionAndLogController extends BaseController {


    @Autowired
    private UserService userService;


    @RequestMapping("/serviceException")
    public AjaxResult serviceException() {
        // 测试统一异常
        return userService.serviceException();
    }


//
    @OperationLog(action = OperationLogAction.ADD)
    @RequestMapping("/logTest")
    public AjaxResult logTest() {
        // 测试日志
        log.info("测试日志");
        return userService.serviceException();
    }


}
