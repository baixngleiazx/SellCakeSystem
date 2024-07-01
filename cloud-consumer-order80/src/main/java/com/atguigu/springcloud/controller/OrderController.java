package com.atguigu.springcloud.controller;

import com.alibaba.fastjson.JSONObject;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentFeignService;
import com.atguigu.springcloud.thread.AsyncTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    PaymentFeignService orderFeignService;
    @Autowired
    AsyncTask asyncTask;

//    @GetMapping("/consumer/payment/create")
//    public CommonResult<Payment> create(Payment payment){
//        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment, CommonResult.class);
//    }
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") int id ){
        return orderFeignService.getPaymentById(id);
    }
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        log.info("*****插入结果" + JSONObject.toJSONString(payment));
        return orderFeignService.create(payment);
    }
}
