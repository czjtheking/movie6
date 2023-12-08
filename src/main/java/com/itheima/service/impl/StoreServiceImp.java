package com.itheima.service.impl;


import com.itheima.dao.CommentDao;
import com.itheima.dao.MovieDao;
import com.itheima.dao.StoreDao;
import com.itheima.domain.Movie;
import com.itheima.domain.Store;
import com.itheima.domain.StoreDetails;
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
    public boolean saveStoreService(Integer userId, Integer movieId) {
        storeDao.saveStore(userId,movieId);
        return true;
    }

    @Override
    public boolean deleteStoreService(Integer storeId) {
        storeDao.deleteStore(storeId);
        return true;
    }

    @Override
    public List<StoreDetails> getAllStoreReturn(Integer userId) {
        List<Store> storeList = storeDao.selectStoreId(userId);
        List<StoreDetails> storeDetailsList = new ArrayList<>();
        for (int i = 0;i < storeList.size();i++){
            Store temp = storeList.get(i);
            Movie movieTemp = commentDao.query1(temp.getMovieId());
            StoreDetails temp2 = new StoreDetails(temp.getStoreId(),userId,movieTemp);
            storeDetailsList.add(temp2);
        }
        return storeDetailsList;
    }

    @Override
    public boolean delStoreBypage(Integer userId, Integer movieId) {
        storeDao.delStoreByuserAndmovie(userId,movieId);
        return true;
    }
}
