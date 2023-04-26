package aca.demo.movierating.movie;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Getter
@Slf4j
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Setter
public class Movie {

    @EqualsAndHashCode.Include
    private Long id;

    private String title;
    private Genre genre;
    private LocalDate releasedAt;
    private String director;
    private double rating;


    public Movie(CreateMovie createMovie) {
        this.title = createMovie.getTitle();
        this.genre = createMovie.getGenre();
        this.director = createMovie.getDirector();
        this.rating = createMovie.getRating();
        this.releasedAt = createMovie.getReleasedAt();
        log.debug("Constructing movie with createMovie - {}"
                , this.title + " " + this.genre + " "
                        + this.director + " " + this.rating + " " + this.releasedAt);
    }
}
