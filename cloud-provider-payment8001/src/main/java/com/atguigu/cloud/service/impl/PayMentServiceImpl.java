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
//    @Transactional
    public int create(Payment payment) {
        ThreadLocal<String> thread = new ThreadLocal<String>();
        int i = paymentDao.create(payment);
        getPaymentById(i);
        return i;
    }

    @Override
//    @Transactional(propagation= Propagation.NESTED)
    public Payment getPaymentById(int id) {
        Payment paymentById = paymentDao.getPaymentById(id);
        return paymentById;
    }
}
