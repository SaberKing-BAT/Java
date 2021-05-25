package com.lyc.springcloud.service.impl;

import com.lyc.springcloud.dao.PaymentDao;
import com.lyc.springcloud.entities.Payment;
import com.lyc.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

   /*
   *    @Resource相当于@AutoWired也能注入依赖，javax自带的
   */
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPayment(id);
    }
}
