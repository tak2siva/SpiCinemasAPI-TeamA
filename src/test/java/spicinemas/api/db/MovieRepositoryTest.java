package spicinemas.api.db;

import org.jooq.DSLContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import spicinemas.SpiCinemasApplication;
import spicinemas.api.model.Movie;
import spicinemas.api.type.MovieListingType;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static spicinemas.db.gen.tables.Movie.MOVIE;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpiCinemasApplication.class)
@ActiveProfiles("test")
public class MovieRepositoryTest {
    @Autowired
    private MovieRepository movieRepo;
    @Autowired
    DSLContext dslContext;

    @Before
    public void init() {

    }

    @After
    public void tearDown() {

    }

    /*
    @Test
    public void shouldInsertUserInDb(){
        String movieName = "Infinity War";
        Movie expectedMovie = new Movie(movieName, "okay", MovieListingType.NOW_SHOWING);
        movieRepo.addMovie(expectedMovie);
        Movie actualMovie = movieRepo.getMovie(movieName);
        assertEquals(actualMovie.getName(), expectedMovie.getName());
    }
    */

    @Test
    public void testIfKabaliIsNowShowingMovie() {
        String movieName = "Kabali";
        Movie movie = movieRepo.getMovie(movieName);
        assertEquals(MovieListingType.NOW_SHOWING,movie.getListingType());
    }

    @Test
    public void testIfThirunaalIsUpcomingMovie() {
        String movieName = "Thirunaal";
        Movie movie = movieRepo.getMovie(movieName);
        assertEquals(MovieListingType.UPCOMING_RELEASE,movie.getListingType());
    }
}