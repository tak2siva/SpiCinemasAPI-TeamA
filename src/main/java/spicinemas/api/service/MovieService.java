package spicinemas.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spicinemas.api.db.MovieRepository;
import spicinemas.api.model.Movie;
import spicinemas.api.type.MovieListingType;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    private static final String COMMA = ",";
    private static final String BLANK = "";

    public List<Movie> getMovies(String location) {
        return repository.getMoviesInLocation( location );
    }


    public List<Movie> getMovies(String location, String language) {
        StringTokenizer languageTokens = new StringTokenizer( language , COMMA );
        List<Movie> movies = new ArrayList<>(  );
        List<Movie> moviesForLocation = this.getMovies(location);
        while (languageTokens.hasMoreTokens())
        {
            List<Movie> moviesForlocationAndALanguage = getMovies( languageTokens.nextToken(), moviesForLocation );
            movies.addAll( moviesForlocationAndALanguage );
        }
        return movies;
    }

    private List<Movie> getMovies(String languageToken, List<Movie> moviesForLocation) {
        String language = languageToken.replace( COMMA , BLANK );
        return moviesForLocation.
                stream().filter( movie -> movie.getLanguage().equals(language) ).collect( toList() );
    }


    public List<Movie> getMovies(String location, String language, String listingType) {
        List<Movie> movies = new ArrayList<>(  );
        List<Movie> moviesforLocation = this.getMovies( location );
        List<Movie> moviesForLocationAndListingType = moviesforLocation.stream().filter( movie -> movie.getListingType().equals( MovieListingType.valueOf(listingType))).collect(toList());
        StringTokenizer languageTokens = new StringTokenizer( language , COMMA);
        while (languageTokens.hasMoreTokens())
        {
            List<Movie> moviesForlocationAndALanguageAndListingType = getMovies( languageTokens.nextToken(), moviesForLocationAndListingType );
            movies.addAll( moviesForlocationAndALanguageAndListingType );
        }
        return movies;
    }
}
