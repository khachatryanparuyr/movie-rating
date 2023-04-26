package aca.demo.movierating.movie;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public List<Movie> search(Genre genre) {
        return movieRepository.findByGenre(genre);
    }

    public Movie getById(Long id) {
        if (movieRepository.findById(id).isEmpty()) {
            throw new MovieNotFoundException("Movie not found");
        } else return movieRepository.findById(id).get();
    }

    public void create(CreateMovie createMovie) {
        //Exception check in the MoveRepository save method
        Movie movie = new Movie(createMovie);
        movieRepository.persist(movie);
    }

    public void update(Long id, UpdateMovie updateMovie) {
        if (checkIsMovieNotFoundException(id)) {
            throw new MovieNotFoundException("Movie not found");
        } else {
            int indexOfMovie = movieRepository.getMovies().indexOf(movieRepository.findById(id).get());
            movieRepository.getMovies().get(indexOfMovie).update(updateMovie);
        }
    }

    public void delete(Long id) {
        if (checkIsMovieNotFoundException(id)) {
            throw new MovieNotFoundException("Movie not found");
        } else {
            movieRepository.delete(movieRepository.findById(id).get());
        }

    }

    public List<Movie> search(Genre genre, String title, LocalDate releasedBefore, LocalDate releasedAfter) {
        return movieRepository.search(genre, title, releasedBefore, releasedAfter);
    }

    public MovieRepository getMovieRepository() {
        return movieRepository;
    }

    public boolean checkIsMovieNotFoundException(Long id) {
        return movieRepository.findById(id).equals(null);
    }
}
