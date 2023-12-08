package com.itheima.service.impl;

import com.itheima.dao.RateDao;
import com.itheima.domain.Rate;
import com.itheima.service.RateService;
import org.springframework.stereotype.Service;

@Service

public class RateServiceImpl implements RateService {
    private RateDao rateDao;

    public RateServiceImpl(RateDao rateDao) {
        this.rateDao = rateDao;
    }

    @Override
    public boolean saveRateService(Rate rate) {
        rateDao.saveRate(rate);
        return true;
    }
}
