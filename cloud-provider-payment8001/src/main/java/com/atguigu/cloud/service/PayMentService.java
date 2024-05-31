package com.atguigu.cloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

import java.util.concurrent.ExecutionException;

public interface PayMentService {
     int create(Payment payment);

     Payment getPaymentById(@Param("id") int id);
}
