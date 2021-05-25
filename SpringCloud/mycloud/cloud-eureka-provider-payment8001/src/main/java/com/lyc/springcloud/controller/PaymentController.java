package com.lyc.springcloud.controller;

import com.lyc.springcloud.entities.CommonResult;
import com.lyc.springcloud.entities.Payment;
import com.lyc.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    @Resource
    DiscoveryClient discoveryClient;
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
    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services=discoveryClient.getServices();
        for(String element:services){
            System.out.println(element);
        }
        List<ServiceInstance> instances=discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance element: instances){
            System.out.println(element.getServiceId()+"\t"+element.getHost()+"\t"+element.getPort()+"\t"+element.getUri());
        }
        return this.discoveryClient;
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

    @GetMapping("/payment/zipkin")
    public String paymentZipkin()
    {
        return "hi ,i'am paymentzipkin server fall back，welcome to atguigu，O(∩_∩)O哈哈~";
    }
}
