package aca.demo.movierating.movie;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
@EqualsAndHashCode
@ToString
public class Movie {
    private String title;
    private Genre genre;

    public Movie(CreateMovie createMovie) {
        this.title = createMovie.getTitle();
        this.genre= createMovie.getGenre();
        log.debug("Constructing movie with createMovie - {}" +
                "represent the createMovie parameter");
    }
}
