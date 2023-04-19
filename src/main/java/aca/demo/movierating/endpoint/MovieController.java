package aca.demo.movierating.endpoint;

import aca.demo.movierating.movie.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;


    @PostMapping("/movies")
    public ResponseEntity create(@PathParam(value = "title") String title, @PathParam(value = "genre") String genre) {
        Genre genreEnum = Genre.valueOf(genre);
        log.info("Genre is -" + genre + " ,   title is -" + title);
        movieService.create(new CreateMovie(title, genreEnum));
        return new ResponseEntity("Created new movie - " + movieService.getMovieRepository().findByTitle(title), HttpStatus.CREATED);

    }


    @GetMapping("/movies/{genre}")
    public ResponseEntity search(@PathVariable String genre) {
        log.info("Parameter genre - " + genre.toUpperCase());
        Genre genreEnum = Genre.valueOf(genre.toUpperCase());
        return new ResponseEntity("Movies by genre - " + genre.toLowerCase() + " " + movieService.search(genreEnum), HttpStatus.ACCEPTED);

    }

    @PutMapping("movies/{title}/{titleUpdate}")
    public ResponseEntity update(@PathVariable String title, @PathVariable String titleUpdate) {
        movieService.getMovieRepository().findByTitle(title).get().setTitle(titleUpdate);
        return new ResponseEntity("Update movie in title " + title + "to - " + titleUpdate, HttpStatus.OK);

    }

    @DeleteMapping("/movies/{title}")
    public ResponseEntity delete(@PathVariable String title) {
        movieService.getMovieRepository().deleteByTitle(title);
        return new ResponseEntity("Movie " + title + " removed", HttpStatus.OK);
    }
    @GetMapping("/movies")
    public ResponseEntity movieList(){
        return new ResponseEntity("Movies  -  " + movieService.getMovieRepository().getMovies().toString(),HttpStatus.OK);
    }


}
