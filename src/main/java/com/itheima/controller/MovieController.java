package com.itheima.controller;


import ch.qos.logback.core.util.FileUtil;
import com.itheima.domain.Movie;
import com.itheima.domain.Rate;
import com.itheima.domain.Result;
import com.itheima.service.MovieService;
import com.itheima.service.RateService;
import com.sun.jndi.toolkit.url.Uri;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/movies")
@CrossOrigin
@Configuration
@ComponentScan("com.itheima.domain")
public class MovieController {
    private MovieService movieService;
    private RateService rateService;
    private final String filePath = System.getProperty("user.dir") + "/static/image/";
    private  final String URL = "http://localhost/image";
    public MovieController(MovieService movieService, RateService rateService) {
        this.movieService = movieService;
        this.rateService = rateService;
    }

    @PostMapping("/search")
    public Result selectMovie(@RequestBody Movie movie){
        List<Movie> movieList = movieService.movieSearchService(movie.getMovieName());
        if (movieList!=null)
        {
            return new Result(Code.GET_OK,movieList,"查找成功");
        }
        else return new Result(Code.GET_ERR,"查找失败");
    }


    @PostMapping("/pop")
    public Result selectPop(){
        List<Movie> movieList = movieService.moviePopService();
        Integer code = movieList !=null?Code.GET_OK:Code.GET_ERR;
        String msg = movieList !=null?"查找成功":"查找失败";
        return new Result(code,movieList,msg);
    }

    @PostMapping("/home")
    public Result giveMain(){
        List<Movie> movieList = movieService.movieMainService();
        List<Movie> movieList2 = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            movieList.add(new Movie());
        }//个性化推荐的四个电影，暂时设置为空，后面要改
        movieList.addAll(movieList2);
        return new Result(Code.GET_OK,movieList,"成功");
    }

    @PostMapping("/add")
    public Result addMovie(@RequestBody Movie movie){
        System.out.println(movie);
        boolean temp = movieService.addMovieService(movie);
        Integer code = temp ?Code.GET_OK:Code.GET_ERR;
        String msg = temp ?"添加成功":"添加失败";
        return new Result(code,msg);
    }

    @PostMapping("/rate")
    public Result movieRate(@RequestBody Rate rate){
        System.out.println(rate);
        boolean temp =  rateService.saveRateService(rate);
        Integer code = temp ?Code.GET_OK:Code.GET_ERR;
        String msg = temp ?"评分成功":"评分失败";
        return new Result(code,msg);
    }

    @PostMapping("uploadPic")
    public Result uploadPic(@RequestParam("file") MultipartFile file) throws MalformedURLException {
        synchronized (MovieController.class) {
            boolean temp = false;
            String fileName = file.getOriginalFilename();
            String realFilePath = filePath + fileName;
            try {
                file.transferTo(new File(realFilePath));
                temp = true;
            } catch (IOException e)
            {
                e.printStackTrace();
            }
            Integer code = temp ? Code.GET_OK : Code.GET_ERR;
            String msg = temp ? "上传成功" : "上传失败";
            String url = realFilePath;
            return new Result(code,URL+File.separator+fileName, msg);
        }
    }
}
