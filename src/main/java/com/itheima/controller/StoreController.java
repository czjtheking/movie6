package com.itheima.controller;


import com.itheima.domain.Result;
import com.itheima.domain.Store;
import com.itheima.domain.StoreDetails;
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
        boolean temp = storeService.saveStoreService(store);
        Integer code = temp ?Code.GET_OK:Code.GET_ERR;
        String msg = temp ?"收藏成功":"电影已收藏，请勿重复收藏";
        return new Result(code,msg);
    }

    @PostMapping("/delstore")
    public Result delete(@RequestBody Store store)
    {
        boolean temp = storeService.deleteStoreService(store.getStoreId());
        Integer code = temp ?Code.GET_OK:Code.GET_ERR;
        String msg = temp ?"删除成功":"删除失败";
        return new Result(code,msg);
    }

    @PostMapping("/getstore")
    public Result getStoreAll(@RequestBody Store store)
    {
        List<StoreDetails> storeDetailsList = storeService.getAllStoreReturn(store.getUserId());
        Integer code = storeDetailsList != null ?Code.GET_OK:Code.GET_ERR;
        String msg = storeDetailsList != null ?"收藏成功":"收藏失败";
        return new Result(code,storeDetailsList,msg);
    }

    @PostMapping("/delstore2")
    public Result deleteStore2(@RequestBody Store store)
    {
        boolean temp = storeService.delStoreBypage(store.getUserId(),store.getMovieId());
        Integer code = temp ?Code.GET_OK:Code.GET_ERR;
        String msg = temp ?"取消收藏成功":"取消收藏失败";
        return new Result(code,msg);
    }
}
