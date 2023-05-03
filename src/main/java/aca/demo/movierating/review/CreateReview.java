package aca.demo.movierating.review;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;

@Slf4j
@Getter
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class CreateReview {
    @EqualsAndHashCode.Include
    private final Long id;

    private final Long movieId;
    private final Long userId;
    private final String description;
    private final double rating;
    private final Instant createdAt;

}
