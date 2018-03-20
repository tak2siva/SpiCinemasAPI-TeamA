CREATE TABLE LOCATION_MOVIE (
	id    SERIAL PRIMARY KEY,
	movie_id INT,
	location_code char(3),
	language_code char(2),

    constraint fk_location_movie_movie
    foreign key (movie_id)
    REFERENCES MOVIE (id) ,

    constraint fk_location_movie_location
    foreign key (location_code)
    REFERENCES LOCATION (code) ,

    constraint fk_language_movie_language
    foreign key (language_code)
    REFERENCES LANGUAGE (code)

);