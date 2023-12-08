package com.itheima.service;

import com.itheima.domain.Rate;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface RateService {
    public boolean saveRateService(Rate rate);
    public double getRate(Rate rate);
}
