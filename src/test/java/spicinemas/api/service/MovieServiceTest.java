package spicinemas.api.service;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import spicinemas.SpiCinemasApplication;
import spicinemas.api.model.Movie;
import spicinemas.api.type.MovieListingType;
import static org.hamcrest.Matchers.*;

import java.beans.Transient;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpiCinemasApplication.class)
@ActiveProfiles("test")
public class MovieServiceTest {

    private static final String EN = "EN" ;
    @Autowired
    MovieService movieService;

    @Test
    public void testMoviesForLocation()
    {
        List<Movie> movies = movieService.getMovies("CHE");
        assertEquals(5, movies.size());

    }

    @Test
    public void testNoMoviesForALocation()
    {
        List<Movie> movies = movieService.getMovies( "PKT" );
        assertEquals( 0, movies.size() );
    }

    @Test
    public void testMoviesForlocationAndLanguage()
    {
        List<Movie> movies = movieService.getMovies( "CHE", "EN" );
        assertThat( movies.stream().map( Movie::getLanguage ).collect( toList() ), everyItem(equalTo( "EN" ) )  );

    }

    @Test
    public void testMoviesForNolocationAndlanguage()
    {
        List<Movie> movies = movieService.getMovies( "PKT", "EN" );
        assertThat( movies.stream().map( Movie::getLanguage ).collect( toList() ), everyItem( isOneOf( "EN" ) )) ;

    }

    @Test
    public void testMoviesForLocationAndMultipleLanguages()
    {
        List<Movie> movies = movieService.getMovies( "TRI" , "EN, FR" );
        assertThat( movies.stream().map( Movie::getLanguage ).collect( toList() ),  everyItem(isOneOf( "EN", "FR" ) )) ;
    }


    @Test
    public void MoviesForLocationAndlanguageAndListingType()
    {
        List<Movie> movies = movieService.getMovies( "CHE" , "EN", String.valueOf( MovieListingType.NOW_SHOWING ));
        assertThat( movies.stream().map( Movie::getListingType ).collect( toList()) , everyItem(equalTo( MovieListingType.NOW_SHOWING ))) ;
        assertThat( movies.stream().map( Movie::getLanguage ).collect( toList() ), everyItem(equalTo( "EN" )  ) );
    }

}