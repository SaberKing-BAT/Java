package com.lyc.springcloud.dao;

import com.lyc.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
//@Repository ( org.springframework.stereotype.Repository)和@Mapper效果一样，但是有些时候插入时会报错，建议用@Mapper
public interface PaymentDao {
    int create(Payment payment);
    Payment getPayment(@Param("id") Long id);
}
