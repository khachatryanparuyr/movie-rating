package aca.demo.movierating.movie;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;

@Value
@Builder
@Jacksonized
public class CreateMovie {
    private final Long id;
    private final String title;
    private final Genre genre;
    private final String director;
    private final double rating;
    private final LocalDate releasedAt;


}
