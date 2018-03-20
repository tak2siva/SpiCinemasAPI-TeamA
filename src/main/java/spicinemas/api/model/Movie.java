package spicinemas.api.model;

import org.jooq.Record5;
import spicinemas.api.type.MovieListingType;
import spicinemas.db.gen.tables.records.MovieRecord;

import java.util.Objects;

public class Movie {
    private Long id;
    private String name;
    private String experiences;
    private MovieListingType listingType;
    private String language;

    public Movie(String name, String experiences, MovieListingType listingType) {
        this.name = name;
        this.experiences = experiences;
        this.listingType = listingType;
    }

    public Movie(MovieRecord movieRecord) {
        this.id = Long.valueOf(movieRecord.getId());
        this.name = movieRecord.getName();
        this.experiences = movieRecord.getExperiences();
        this.listingType = MovieListingType.valueOf(movieRecord.getListingType());
    }

    public Movie(Record5<Integer, String, String, String, String> movieRecord) {
        this.id = Long.valueOf(movieRecord.value1());
        this.name = movieRecord.value2();
        this.experiences = movieRecord.value3();;
        this.listingType = MovieListingType.valueOf(movieRecord.value4());
        this.language = movieRecord.value5();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getExperiences() {
        return experiences;
    }

    public MovieListingType getListingType() {
        return listingType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}