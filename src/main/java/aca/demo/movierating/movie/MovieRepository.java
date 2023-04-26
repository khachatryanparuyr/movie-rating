package aca.demo.movierating.movie;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Component
@Slf4j
public class MovieRepository {
    private List<Movie> movies = new ArrayList<>();


    public Optional<Movie> findById(Long id) {
        return movies.stream().filter(movie -> movie.getId().equals(id)).findFirst();
    }

    public void persist(Movie movie) {
        movies.add(movie);
    }

    public void delete(Movie movie) {
        movies.removeIf(movie1 -> movie1.getId().equals(movie.getId()));
    }

    List<Movie> search(Genre genre, String title, LocalDate releasedBefore, LocalDate releasedAfter) {
        Stream<Movie> movieStream = movies.stream();

        if (genre != null) {
            movieStream.filter(movie -> movie.getGenre().equals(genre));
        }
        if (title != null) {
            movieStream.filter(movie -> movie.getTitle().equals(title));
        }
        if (releasedAfter != null && releasedBefore != null) {
            movieStream.filter(movie -> movie.getReleasedAt().isAfter(releasedAfter) && movie.getReleasedAt().isBefore(releasedBefore));

        }
        return movieStream.collect(Collectors.toList());
    }


    public List<Movie> findByGenre(Genre genre) {
        log.debug("method findByGenre - {}" +
                "running");
        return movies.stream().filter(movie -> movie.getGenre().equals(genre)).collect(Collectors.toList());
    }


    public List<Movie> getMovies() {
        return movies;
    }
}
