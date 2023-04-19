package aca.demo.movierating.movie;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Slf4j
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public List<Movie> search(Genre genre) {
        return movieRepository.findByGenre(genre);
    }

    public void create(CreateMovie createMovie) {
        //Exception check in the MoveRepository save method
        movieRepository.save(createMovie);
    }

    public MovieRepository getMovieRepository() {
        return movieRepository;
    }
}
