package spicinemas.api.model;

import lombok.EqualsAndHashCode;
import spicinemas.api.type.MovieListingType;
import spicinemas.db.gen.tables.records.MovieRecord;

import java.util.Objects;

public class Movie {
    private Long id;
    private String name;
    private String experiences;
    private MovieListingType listingType;

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