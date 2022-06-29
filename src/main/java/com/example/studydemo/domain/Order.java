package com.example.studydemo.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("Orders")
@Data
public class Order {

    private String orderNum;
    private String custId;
}
