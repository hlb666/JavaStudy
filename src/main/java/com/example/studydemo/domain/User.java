package com.example.studydemo.domain;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("User")
@Data
public class User {

    @TableId
    private Integer Id;

    private String name;

    private String adress;

    private String email;

}
