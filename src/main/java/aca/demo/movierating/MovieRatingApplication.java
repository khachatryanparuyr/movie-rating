package aca.demo.movierating;

import aca.demo.movierating.movie.CreateMovie;
import aca.demo.movierating.movie.Genre;
import aca.demo.movierating.movie.Movie;
import aca.demo.movierating.movie.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@Slf4j
public class MovieRatingApplication {

    public static void main(String[] args) {
       var applicationContext = SpringApplication.run(MovieRatingApplication.class, args);

        var movieService = applicationContext.getBean(MovieService.class);

        movieService.create(new CreateMovie("Forrest Gump", Genre.DRAMA));
        movieService.create(new CreateMovie("Horrible Bosses", Genre.COMEDY));
        movieService.create(new CreateMovie("American Beauty", Genre.DRAMA));
        log.debug("movies with genre DRAMA: {}" + movieService.search(Genre.DRAMA));
        log.debug("movies with genre ROMANCE: {}" + movieService.search(Genre.ROMANCE));
        movieService.create(new CreateMovie("Forrest Gump",Genre.COMEDY));



    }



}
