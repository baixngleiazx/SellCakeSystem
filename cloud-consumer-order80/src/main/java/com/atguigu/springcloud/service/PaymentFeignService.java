package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "CLOUD-PAYMENT-SERVICE",fallback = PaymentFeignServiceImpl.class)
public interface PaymentFeignService {
    @RequestMapping("/payment/get/{id}")
    CommonResult getPaymentById(@PathVariable("id") int id);

    @PostMapping(value = "/payment/create")
    CommonResult create(@RequestBody Payment payment);
}
