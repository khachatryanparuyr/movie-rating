package aca.demo.movierating.endpoint;

import aca.demo.movierating.movie.MovieNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.event.Level;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GeneralExceptionHandler {

    @ExceptionHandler
    ResponseEntity<ErrorResponse> handle(MovieNotFoundException movieNotFoundException) {
        log.atLevel(Level.ERROR);
        movieNotFoundException.getMessage();
        return new ResponseEntity<>(new ErrorResponse(1001, "Bad Request", null), HttpStatus.valueOf(400));
    }

    @ExceptionHandler
    ResponseEntity<ErrorResponse> handle(RuntimeException runtimeException) {
        log.atLevel(Level.ERROR);
        return new ResponseEntity<>(new ErrorResponse(1100, "Internal Server Error", null), HttpStatus.valueOf(500));
    }


}
