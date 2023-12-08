package com.itheima.service;

import com.itheima.domain.Store;
import com.itheima.domain.StoreDetails;

import java.util.List;

public interface StoreService {
    List<Store> getAllStore(Integer userId);
    boolean saveStoreService(Integer userId, Integer movieId);
    boolean deleteStoreService(Integer storeId);
    List<StoreDetails> getAllStoreReturn(Integer userId);
    boolean delStoreBypage(Integer userId, Integer movieId);
}
