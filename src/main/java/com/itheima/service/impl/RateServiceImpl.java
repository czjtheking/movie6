package com.itheima.service.impl;

import com.itheima.dao.RateDao;
import com.itheima.domain.Rate;
import com.itheima.service.RateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class RateServiceImpl implements RateService {
    private RateDao rateDao;

    public RateServiceImpl(RateDao rateDao) {
        this.rateDao = rateDao;
    }

    @Override
    public boolean saveRateService(Rate rate) {
        List<Rate> rateList = rateDao.isRepeat(rate.getUserId(),rate.getMovieId());
        System.out.println(rateList);
        if (rateList.size()==0)
        {
            rateDao.saveRate(rate);
            return true;
        }
        else
        {
            return rateDao.updateRate(rate.getRateNum(),rate.getUserId(),rate.getMovieId())>0;
       }

    }

    @Override
    public double getRate(Rate rate) {
        double rateNum = rateDao.findRateNum(rate.getUserId(),rate.getMovieId());
        return rateNum;
    }
}
