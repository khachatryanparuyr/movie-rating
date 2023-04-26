package aca.demo.movierating.endpoint;

import aca.demo.movierating.movie.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;


    @GetMapping("/{id}")
    Movie getById(@PathVariable Long id) {
        return movieService.getById(id);
    }

    @PostMapping
    ResponseEntity create(CreateMovie createMovie) {
        movieService.create(createMovie);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("{id}")
    void update(@PathVariable Long id, UpdateMovie updateMovie) {
        movieService.update(id, updateMovie);
    }

    @DeleteMapping("{id}")
    void delete(@PathVariable Long id) {
        movieService.delete(id);
    }

    @GetMapping
    List<Movie> search(@RequestParam Genre genre, @RequestParam String title, @RequestParam LocalDate releasedBefore, @RequestParam LocalDate releasedAfter) {
       return movieService.search(genre, title, releasedBefore, releasedAfter);
    }

}
