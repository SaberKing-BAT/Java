package com.lyc.springcloud.controller;

import com.lyc.springcloud.entities.CommonResult;
import com.lyc.springcloud.entities.Payment;
import com.lyc.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private PaymentService paymentService;
    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment, HttpServletRequest request){
        System.out.println(request.getContentType());
        int result=paymentService.create(payment);
        log.info("********插入结果："+result);
        if (result>0)
            return new CommonResult(200,"插入成功"+serverPort,result);
        else
            return new CommonResult(444,"插入失败"+serverPort,null);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment=paymentService.getPaymentById(id);
        log.info("*******查询结果："+payment);
        if(payment!=null)
            return new CommonResult(200,"查询成功!!!"+serverPort,payment);
        else
            return new CommonResult(444,"查询失败!!!"+serverPort,null);
    }
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){
        System.out.println("*******paymentFeignTimeOut from port:"+serverPort);
        try{
            TimeUnit.SECONDS.sleep(3);
        }
        catch (InterruptedException e)
        {e.printStackTrace();}
        return  serverPort;
    }
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB()
    {
        return serverPort;
    }
}
