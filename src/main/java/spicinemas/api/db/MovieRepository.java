package spicinemas.api.db;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spicinemas.api.model.Movie;
import spicinemas.api.type.MovieListingType;
import spicinemas.db.gen.tables.records.MovieRecord;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static spicinemas.db.gen.tables.LocationMovie.LOCATION_MOVIE;
import static spicinemas.db.gen.tables.Movie.MOVIE;
import static spicinemas.db.gen.tables.MovieLanguage.MOVIE_LANGUAGE;

@Repository
@Transactional
public class MovieRepository {
    @Autowired
    private DSLContext dsl;

    public List<Movie> getNowShowingMovies() {
         return dsl.selectFrom(MOVIE).where(MOVIE.LISTING_TYPE.eq(MovieListingType.NOW_SHOWING.name())).fetchMap(MOVIE.ID)
                 .values()
                 .stream().map(Movie::new).collect(toList());
    }

    public List<Movie> getUpcomingMovies() {
        return dsl.selectFrom(MOVIE).where(MOVIE.LISTING_TYPE.eq(MovieListingType.UPCOMING_RELEASE.name())).fetchMap(MOVIE.ID)
                .values()
                .stream().map(Movie::new).collect(toList());
    }

    public void addMovie(Movie movie) {
        dsl.insertInto(MOVIE)
                .columns(MOVIE.NAME, MOVIE.EXPERIENCES, MOVIE.LISTING_TYPE)
                .values(movie.getName(), movie.getExperiences(), movie.getListingType().toString())
                .execute();
    }

    public Movie getMovie(String name) {
        MovieRecord movieRecord = dsl
                .selectFrom(MOVIE)
                .where(MOVIE.NAME.eq(name))
                .fetchOne()
                .into(MovieRecord.class);
        return new Movie(movieRecord);
    }

    public List<Movie> getMoviesInLocation(String locationCode) {
        return dsl.select(
            MOVIE.ID.as("id"),
            MOVIE.NAME.as("movie_name"),
            MOVIE.EXPERIENCES.as("experience"),
            MOVIE.LISTING_TYPE.as("listing_type"),
            LOCATION_MOVIE.LANGUAGE_CODE.as("language_type")
        ).from(MOVIE)
            .innerJoin(LOCATION_MOVIE)
            .on(MOVIE.ID.eq(LOCATION_MOVIE.MOVIE_ID))
            .where(LOCATION_MOVIE.LOCATION_CODE.eq(locationCode))
            .fetch()
            .stream()
            .map(Movie::new)
            .collect(toList());
    }
}
