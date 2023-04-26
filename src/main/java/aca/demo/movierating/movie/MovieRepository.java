package aca.demo.movierating.movie;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
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


    public Optional<Movie> findById(Long id) {
        Movie movieById = movies.stream().filter(movie -> movie.getId().equals(id)).distinct().findFirst().orElse(null);
        Optional<Movie> optionalMovie = Optional.of(movieById);
        return optionalMovie.isEmpty() ? Optional.empty() : optionalMovie;
    }

    public void persist(Movie movie) {
        movies.add(movie);
    }

    public void delete(Movie movie) {
        movies.removeIf(movie1 -> movie1.getId().equals(movie.getId()));
    }

    List<Movie> search(Genre genre, String title, LocalDate releasedBefore, LocalDate releasedAfter) {
        if (genre != null) {
            return movies.stream().filter(movie -> movie.getGenre().equals(genre)).collect(Collectors.toList());
        } else if (title != null) {
            return movies.stream().filter(movie -> movie.getTitle().equals(title)).collect(Collectors.toList());
        } else if (releasedAfter != null && releasedBefore != null) {
            return movies.stream().filter(movie -> movie.getReleasedAt().isAfter(releasedAfter) && movie.getReleasedAt().isBefore(releasedBefore)).
                    collect(Collectors.toList());
        }

        return movies;
    }

    public Optional<Movie> findByTitle(String title) {
        log.debug("method findByTitle - {}", title +
                " running");
        Movie movieByTitle = movies.stream().distinct().filter(movie1 -> movie1.getTitle().equals(title)).findFirst().orElse(null);
        Optional<Movie> optionalMovie = Optional.of(movieByTitle);
        return optionalMovie.isEmpty() ? Optional.empty() : optionalMovie;
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

    public void deleteByTitle(String title) {
        Movie movie = findByTitle(title).get();
        movies.removeIf(movie1 -> movie1.equals(movie));

    }


    public List<Movie> getMovies() {
        return movies;
    }
}
