package aca.demo.movierating;

import aca.demo.movierating.movie.CreateMovie;
import aca.demo.movierating.movie.Genre;
import aca.demo.movierating.movie.Movie;
import aca.demo.movierating.movie.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@Slf4j
public class MovieRatingApplication {

    public static void main(String[] args) {
       var applicationContext = SpringApplication.run(MovieRatingApplication.class, args);

        var movieService = applicationContext.getBean(MovieService.class);
        LocalDate localDate = LocalDate.of(2020,4,15);
        LocalDate localDate1 = LocalDate.of(2023,4,15);
        LocalDate localDate2 = LocalDate.of(2021,4,15);

        movieService.create(CreateMovie.builder().id(1L).title("Forrest Gump").genre(Genre.DRAMA).rating(4.2).director("Arman").releasedAt(localDate).build());
        movieService.create(CreateMovie.builder().id(2L).title("Lost").genre(Genre.DRAMA).rating(4.5).director("Poxos").releasedAt(localDate1).build());
        movieService.create(CreateMovie.builder().id(3L).title("Lost 2").genre(Genre.DRAMA).rating(4.3).director("Petros").releasedAt(localDate2).build());




    }



}
