package spicinemas.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spicinemas.api.db.MovieRepository;
import spicinemas.api.model.Movie;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository repository;

    public List<Movie> getMovies(String location) {
        return repository.getMoviesInLocation( location );
    }

}
