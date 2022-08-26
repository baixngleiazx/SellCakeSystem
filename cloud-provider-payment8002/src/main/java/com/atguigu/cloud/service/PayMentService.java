package com.atguigu.cloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PayMentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
