package com.atguigu.cloud.service.impl;

import com.atguigu.cloud.dao.PaymentDao;
import com.atguigu.cloud.service.PayMentService;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PayMentServiceImpl implements PayMentService {
    @Resource
    private PaymentDao paymentDao;
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
