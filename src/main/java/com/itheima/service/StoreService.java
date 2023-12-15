package com.itheima.service;

import com.itheima.domain.Store;
import com.itheima.domain.StoreDetails;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional

public interface StoreService {
    List<Store> getAllStore(Integer userId);
    boolean saveStoreService(Store store);
    boolean deleteStoreService(Integer storeId);
    List<StoreDetails> getAllStoreReturn(Integer userId);
    boolean delStoreBypage(Integer userId, Integer movieId);
    boolean isStore(Integer userId,Integer movieID);
}
