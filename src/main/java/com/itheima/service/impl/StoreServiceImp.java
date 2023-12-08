package com.itheima.service.impl;


import com.itheima.dao.CommentDao;
import com.itheima.dao.MovieDao;
import com.itheima.dao.StoreDao;
import com.itheima.domain.Movie;
import com.itheima.domain.Store;
import com.itheima.domain.storeDetails;
import com.itheima.service.StoreService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreServiceImp implements StoreService {

    private StoreDao storeDao;
    private MovieDao movieDao;
    private CommentDao commentDao;

    public StoreServiceImp(StoreDao storeDao, MovieDao movieDao, CommentDao commentDao) {
        this.storeDao = storeDao;
        this.movieDao = movieDao;
        this.commentDao = commentDao;
    }

    @Override
    public List<Store> getAllStore(Integer userId) {
        List<Store> storeList = storeDao.selectStore(userId);
        return storeList;
    }

    @Override
    public void saveStore(Integer userId, Integer movieId) {
        storeDao.saveStore(userId,movieId);
    }

    @Override
    public void deleteStore(Integer storeId) {
        storeDao.deleteStore(storeId);
    }

    @Override
    public List<storeDetails> getAllStoreReturn(Integer userId) {
        List<Store> storeList = storeDao.selectStoreId(userId);
        List<storeDetails> storeDetailsList = new ArrayList<>();
        for (int i = 0;i < storeList.size();i++){
            Store temp = storeList.get(i);
            Movie movieTemp = commentDao.query1(temp.getMovieId());
            storeDetails temp2 = new storeDetails(temp.getStoreId(),userId,movieTemp);
            storeDetailsList.add(temp2);
        }
        return storeDetailsList;
    }
}
