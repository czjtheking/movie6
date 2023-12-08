package com.itheima.service;

import com.itheima.domain.Store;
import com.itheima.domain.storeDetails;

import java.util.List;

public interface StoreService {
    public List<Store> getAllStore(Integer userId);
    public void saveStore(Integer userId,Integer movieId);
    public void deleteStore(Integer storeId);
    public List<storeDetails> getAllStoreReturn(Integer userId);
}
