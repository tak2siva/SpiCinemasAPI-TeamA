package spicinemas.api.db;

import spicinemas.api.model.Movie;
import spicinemas.api.type.MovieListingType;
import spicinemas.db.gen.tables.records.MovieRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static spicinemas.db.gen.tables.Movie.MOVIE;

@Repository
@Transactional
public class MovieRepository {
    @Autowired
    private DSLContext dsl;

    public List<MovieRecord> getNowShowingMovies() {
        return dsl.selectFrom(MOVIE)
           .where(MOVIE.LISTING_TYPE.eq(MovieListingType.NOW_SHOWING.name()))
           .fetchInto(MovieRecord.class);
    }

    public void addMovie(Movie movie) {
        dsl.insertInto(MOVIE)
                .columns(MOVIE.NAME)
                .values(movie.getName())
                .execute();
    }

    public Movie getMovie(String name) {
        MovieRecord movieRecord = dsl.select()
                .from(MOVIE)
                .where(MOVIE.NAME.eq(name))
                .fetchOne()
                .into(MovieRecord.class);
        return new Movie(movieRecord);
    }
}
