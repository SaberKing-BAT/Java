package com.lyc.springcloud.controller;

import com.lyc.springcloud.entities.CommonResult;
import com.lyc.springcloud.entities.Payment;
import com.lyc.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class OrderController {
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    //    public static final String PAYMENT_URL = "http://localhost:8001";
    @Resource
    private RestTemplate restTemplate;

    //自定义负载均衡
    @Resource
    private LoadBalancer loadBalancer;
    @Resource
    DiscoveryClient discoveryClient;

    @PostMapping("/consumer/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        log.info("*******调用生产者payment——>create");
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        log.info("*******调用生产者payment——>get");
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class, id);
    }

    //返回对象为ResponseEntity 包含了响应中的一些重要信息，比如响应头、响应状态码、响应体等
    /*
    * <200,CommonResult(code=200, message=查询成功!!!8001, data={id=2, serial=呃呃的}),[Content-Type:"application/json",
    * Transfer-Encoding:"chunked", Date:"Tue, 27 Apr 2021 02:37:39 GMT", Keep-Alive:"timeout=60", Connection:"keep-alive"]>
    */
    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        log.info(entity.toString());
        if (entity.getStatusCode().is2xxSuccessful())
            return entity.getBody();
        else
            return new CommonResult<>(444,"操作失败");

    }


    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB()
    {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        if(instances == null || instances.size() <= 0)
        {
            return null;
        }

        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();

        return restTemplate.getForObject(uri+"/payment/lb",String.class);

    }
    // ====================> zipkin+sleuth
    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin()
    {
        String result = restTemplate.getForObject("http://localhost:8001"+"/payment/zipkin/", String.class);
        return result;
    }


}
/*
 *   postForObject方法用的Content-Type是    application/json json参数是放在请求体的，所以用@RequstBody 接受
 * */