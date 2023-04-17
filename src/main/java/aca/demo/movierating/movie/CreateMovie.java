package aca.demo.movierating.movie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Value
public class CreateMovie {
    private final String title;
    private final Genre genre;


}
