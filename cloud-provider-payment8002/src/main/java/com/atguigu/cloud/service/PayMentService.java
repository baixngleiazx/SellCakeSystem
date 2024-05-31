package com.atguigu.cloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PayMentService {

     int create(Payment payment);

     Payment getPaymentById(@Param("id") int id);
}
