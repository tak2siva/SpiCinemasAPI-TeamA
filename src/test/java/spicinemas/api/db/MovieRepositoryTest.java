package spicinemas.api.db;

import spicinemas.api.model.Movie;
import spicinemas.api.type.MovieListingType;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest()
@ActiveProfiles("ci")
@Ignore
public class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void shouldInsertUserInDb(){
        String movieName = "Infinity War";
        Movie expectedMovie = new Movie(movieName, "", MovieListingType.NOW_SHOWING);
        movieRepository.addMovie(expectedMovie);
        Movie actualMovie = movieRepository.getMovie(movieName);
        assertThat(actualMovie, is(expectedMovie));
    }
}