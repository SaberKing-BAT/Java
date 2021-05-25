package com.lyc.springcloud.controller;

import com.lyc.springcloud.entities.CommonResult;
import com.lyc.springcloud.entities.Payment;
import com.lyc.springcloud.serivce.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id)
    {
        return paymentFeignService.getPaymentById(id);
    }

    /*
    * 默认1秒超时 openfeign*/
    @GetMapping("/consumer/payment/openfeign/timeout")
    public String paymentFeignTimeOut(){
        return paymentFeignService.paymentFeignTimeout();
    }
}
