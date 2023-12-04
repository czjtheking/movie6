package com.itheima.controller;


import com.itheima.domain.Movie;
import com.itheima.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@CrossOrigin

public class MovieController {
    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/search")
    public Result selectMovie(@RequestBody Movie movie){
        //System.out.println(movie);
        List<Movie> movieList = movieService.movieSearchService(movie.getMovieName());
        if (movieList!=null)
        {
            return new Result(Code.GET_OK,movieList,"查找成功");
        }
        else return new Result(Code.GET_ERR,"查找失败");
    }

}
