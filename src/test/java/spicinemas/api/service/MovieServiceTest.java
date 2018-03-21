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


    @Autowired
    MovieService movieService;

    @Test
    public void testMoviesForLocation()
    {
        List<Movie> movies = movieService.getMovies("CHE");
        assertThat( movies.stream().map( Movie::getName ).collect( toList() ), containsInAnyOrder( "Kabali", "Sultan" , "Thirunaal", "Banjo", "Suicide Squad")  );
    }

    @Test
    public void testNoMoviesForALocation()
    {
        List<Movie> movies = movieService.getMovies( "PKT" );
        assertEquals( 0, movies.size() );
    }

    @Test
    public void testMoviesForlocationAndListing()
    {
        List<Movie> movies = movieService.getMovies( "CHE", String.valueOf( MovieListingType.NOW_SHOWING ) );
        assertThat( movies.stream().map( Movie::getListingType ).collect( toList() ), everyItem(equalTo( MovieListingType.NOW_SHOWING ) )  );

    }

    @Test
    public void testMoviesForNolocationAndlisting()
    {
        List<Movie> movies = movieService.getMovies( "PKT", String.valueOf( MovieListingType.NOW_SHOWING ) );
        assertThat( movies.stream().map( Movie::getListingType ).collect( toList() ), everyItem( equalTo( "NOW_SHOWING" ) )) ;

    }

    @Test
    public void testMoviesForLocationListingAndMultipleLanguages()
    {
        List<Movie> movies = movieService.getMovies( "TRI" , String.valueOf( MovieListingType.NOW_SHOWING ) ,"EN, FR" );
        assertThat( movies.stream().map( Movie::getLanguage ).collect( toList() ),  everyItem(isOneOf( "EN", "FR" ) )) ;
    }


    @Test
    public void testMoviesForLocationAndlanguageAndListingType()
    {
        List<Movie> movies = movieService.getMovies( "CHE" , String.valueOf( MovieListingType.NOW_SHOWING ), "EN");
        assertThat( movies.stream().map( Movie::getListingType ).collect( toList()) , everyItem(equalTo( MovieListingType.NOW_SHOWING ))) ;
        assertThat( movies.stream().map( Movie::getLanguage ).collect( toList() ), everyItem(equalTo( "EN" )  ) );
    }

}