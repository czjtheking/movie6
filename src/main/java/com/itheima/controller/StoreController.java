package com.itheima.controller;


import com.itheima.domain.Result;
import com.itheima.domain.Store;
import com.itheima.domain.storeDetails;
import com.itheima.service.MovieService;
import com.itheima.service.StoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store")
@CrossOrigin
public class StoreController {
    private StoreService storeService;
    private MovieService movieService;

    public StoreController(StoreService storeService, MovieService movieService) {
        this.storeService = storeService;
        this.movieService = movieService;
    }

    @PostMapping("/commit")
    public Result commit(@RequestBody Store store)
    {
        System.out.println(store);
        storeService.saveStore(store.getUserId(),store.getMovieId());
        return new Result(Code.GET_OK,"收藏成功");
    }

    @PostMapping("/delstore")
    public Result delete(@RequestBody Store store)
    {
        storeService.deleteStore(store.getStoreId());
        return new Result(Code.GET_OK,"删除成功");
    }

    @PostMapping("/getstore")
    public Result getStoreAll(@RequestBody Store store)
    {
        System.out.println(store);
        List<storeDetails> storeDetailsList = storeService.getAllStoreReturn(store.getUserId());
        return new Result(Code.GET_OK,storeDetailsList,"获取成功");
    }
}
