package aca.demo.movierating.movie;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.HexFormat.of;

@Component
@Slf4j
public class MovieRepository {
    private List<Movie> movies = new ArrayList<>();

    public Optional<Movie> findByTitle(String title) {
        log.debug("method findByTitle - {}" +
                "running");
        List<Movie> movieList = movies.stream().distinct().filter(movie1 -> movie1.getTitle().equals(title)).collect(Collectors.toList());
        Optional<Movie> optionalMovie;
        if (movieList.isEmpty()) {
            return Optional.empty();
        } else {
            optionalMovie = Optional.of(movieList.get(0));
        }
        return optionalMovie;
    }

    public List<Movie> findByGenre(Genre genre) {
        log.debug("method findByGenre - {}" +
                "running");
        return movies.stream().filter(movie -> movie.getGenre().equals(genre)).collect(Collectors.toList());
    }

    public void save(CreateMovie createMovie) {
        log.debug("method save Movie - {}" +
                "running");
        if (!findByTitle(createMovie.getTitle()).isEmpty()) {
            throw new IllegalArgumentException("Please rename movie name");
        } else {
            Movie movie = new Movie(createMovie);
            movies.add(movie);
        }
    }


    public List<Movie> getMovies() {
        return movies;
    }
}
