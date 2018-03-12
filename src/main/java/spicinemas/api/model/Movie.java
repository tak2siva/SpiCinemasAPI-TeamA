package spicinemas.api.model;

import spicinemas.api.type.MovieListingType;
import spicinemas.db.gen.tables.records.MovieRecord;

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
}