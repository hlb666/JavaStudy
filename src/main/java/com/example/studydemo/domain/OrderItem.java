package com.example.studydemo.domain;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.data.annotation.Id;

@TableName("OrderItems")
@Data
public class OrderItem {

    @TableId
    private String orderNum;

    private Integer itemPrice;

    private Integer quantity;

}
