package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentFeignServiceImpl implements PaymentFeignService {
    public CommonResult getPaymentById(Long id) {
        return new CommonResult(404, "服务熔断");
    }

    public CommonResult create(Payment payment) {
        return new CommonResult(200, "服务熔断");
    }
}
