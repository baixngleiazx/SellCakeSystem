package com.atguigu.cloud.controller;

import com.atguigu.cloud.service.PayMentService;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@RestController
@RequestMapping("paymentController")
@Slf4j
public class PaymentController {
    @Resource
    PayMentService payMentService;
    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = payMentService.create(payment);
        log.info("*****插入结果" + result+"nihao");
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功！serverPort:"+serverPort, result);
        } else {
            return new CommonResult(444, "插入数据库失败！", result);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") int id) {
        Payment payment = payMentService.getPaymentById(id);
        log.info("*****查询结果" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询数据库成功！serverPort:"+serverPort ,payment);
        } else {
            return new CommonResult(444, "查询数据库失败！", payment);
        }
    }
}
