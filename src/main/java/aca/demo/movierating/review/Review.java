package aca.demo.movierating.review;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
@Slf4j
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@AllArgsConstructor
public class Review {
    @EqualsAndHashCode.Include
    private final Long id;

    private final Long movieId;
    private final Long userId;
    private final String description;
    private final double rating;
    private final Instant createdAt;
    private final Instant updatedAt;
}
