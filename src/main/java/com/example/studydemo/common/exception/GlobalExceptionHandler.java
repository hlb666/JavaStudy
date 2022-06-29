package com.example.studydemo.common.exception;


import com.example.studydemo.common.core.domain.AjaxResult;
import com.example.studydemo.common.exception.exceptionbycustom.ServiceException;
import com.example.studydemo.common.utils.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     *  捕获自定义的业务异常
     *  在try cache 中需要手动的抛出
     */
    @ExceptionHandler(ServiceException.class)
    public AjaxResult handleServiceException(ServiceException e, HttpServletRequest request)
    {

//        Integer code = e.getCode();
        String requestURI = request.getRequestURI();
        return AjaxResult.error("service异常，路径为："+requestURI);
    }


    /**
     * 拦截未知的运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    public AjaxResult handleRuntimeException(RuntimeException e, HttpServletRequest request)
    {
        String requestURI = request.getRequestURI();
//        log.error("请求地址'{}',发生未知异常.", requestURI, e);
        return AjaxResult.error("运行异常，路径为:"+requestURI);
    }

    /**
     * 系统异常
     */
    @ExceptionHandler(Exception.class)
    public AjaxResult handleException(Exception e, HttpServletRequest request)
    {
        String requestURI = request.getRequestURI();
//        log.error("请求地址'{}',发生系统异常.", requestURI, e);
        return AjaxResult.error("系统异常，路径为:"+requestURI);
    }



}
