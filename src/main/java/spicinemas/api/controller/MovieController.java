package spicinemas.api.controller;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import spicinemas.api.db.MovieRepository;
import spicinemas.api.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import spicinemas.api.service.MovieService;
import spicinemas.api.type.MovieListingType;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    private MovieRepository movieRepo;
    @Autowired
    private MovieService movieService;

    @RequestMapping(value = "/init",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public void init() {
        //movieRepo.addMovie(new Movie("Dunkirk", "good", MovieListingType.NOW_SHOWING));
    }

    @RequestMapping(value = "/movies/now-showing",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Movie> getNowShowingMovies() {
        return movieRepo.getNowShowingMovies();
    }

    @RequestMapping(value = "/movies/upcoming-release",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Movie> getUpcomingMovies() {
        return movieRepo.getUpcomingMovies();
    }

    @RequestMapping(value = "/location/{locationCode}/movies",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Movie> getMoviesInLocation(@PathVariable String locationCode){
        return movieRepo.getMoviesInLocation(locationCode);
    }

    @RequestMapping(value = "movies",
            method = RequestMethod.GET)
    public List<Movie> getMovies(@RequestParam("location") String locationCode, @RequestParam("language") String language, @RequestParam("listingType") String listingType){
        return movieService.getMovies( locationCode, language, listingType );
    }


}
