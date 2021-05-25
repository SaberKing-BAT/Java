package com.lyc.springcloud.controller;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Slf4j
@RestController
public class OrderZKController {
    public static final String INVOKE_URL="http://cloud-provider-payment";
    @Resource
    private RestTemplate restTemplate;
    @RequestMapping("/consumer/payment/zk")
    public String paymentInfo(){
        String result =restTemplate.getForObject(INVOKE_URL+"/payment/zk",String.class);
        log.info("消费者调用支付服务（zookeeper）---》result"+result);
        return result;
    }
}
