package com.example.studydemo.common.annotation;


import com.example.studydemo.common.enums.OperationLogAction;


import java.lang.annotation.*;

@Target({ ElementType.PARAMETER, ElementType.METHOD }) // 注解放置的目标位置,METHOD是可注解在方法级别上
@Retention(RetentionPolicy.RUNTIME) // 注解在哪个阶段执行
@Documented
public @interface OperationLog {

    /**
     * 操作类型，登陆、查询、新增、修改、删除、预览等
     */
     OperationLogAction action();


}
