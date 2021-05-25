package com.lyc.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Component
public class PaymentHystrixService {
    /**
     * 正常访问，一切OK
     * @param id
     * @return
     */

   public String paymentInfo_OK(@PathVariable("id") Integer id){
        return "线程池:"+Thread.currentThread().getName()+"paymentInfo_OK,id: "+id+"\t"+"O(∩_∩)O";
    }
    /**
     * 超时访问，演示降级
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "6000")})
   public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
//        int var= 3/0; //非超时异常
        try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }  //超时异常
        return "线程池:"+Thread.currentThread().getName()+"paymentInfo_TimeOut,id: "+id+"\t"+"O(∩_∩)O，耗费3秒";
    }

    //异常兜底方案
    public String paymentInfo_TimeOutHandler(Integer id){
        return "/(ㄒoㄒ)/调用支付接口超时或异常：\t"+ "\t当前线程池名字" + Thread.currentThread().getName();
    }


    //============服务熔断 来自HystrixCommandProperties类
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name= "circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage", value = "60")  //错误阈值百分比

    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id)
    {
        if (id<0)
        {
            throw new RuntimeException("****id 不能为负");
            
        }
        String serialNumber= IdUtil.simpleUUID();
        return Thread.currentThread().getName()+ "\t" +"调用成功，流水号: " + serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return  "id 不能负数，稍后再试 /(ㄒoㄒ)/~~   id:"+id;
    }


}


