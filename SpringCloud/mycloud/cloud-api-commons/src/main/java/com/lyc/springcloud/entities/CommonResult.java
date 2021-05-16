package com.lyc.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: LYC
 * @Date: 2021/4/21 17:20
 * @Description: 返回给前端的统一json实体
 * @FuntionName:
 * @Param:
 * @Return: R
 **/


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T>
{
    private Integer code;
    private String  message;
    private T data;

//    两个参数的构造器
    public CommonResult(Integer code, String message)
    {
        this(code,message,null);
    }
}


