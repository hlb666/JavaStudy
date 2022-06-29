package com.example.studydemo.controller;

import com.example.studydemo.common.core.controller.BaseController;
import com.example.studydemo.common.core.domain.AjaxResult;
import com.example.studydemo.common.core.redis.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping("redis")
public class RedisCacheTestController extends BaseController {

    @Autowired
    private RedisCache redisCache;


    //模拟缓存tonken 并设置失效时间
    @PostMapping("/setTokenCache")
    public AjaxResult setTokenCache(@RequestParam("token") String token){
        redisCache.setCacheObject("token", token, 2, TimeUnit.HOURS);
        return AjaxResult.success();
    }

    @PostMapping("/getTokenCache")
    public AjaxResult getTokenCache(@RequestParam("key") String key) {
        Object cacheObject = redisCache.getCacheObject(key);
        return AjaxResult.success(cacheObject);
    }







}
