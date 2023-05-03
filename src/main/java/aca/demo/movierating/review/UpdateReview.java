package aca.demo.movierating.review;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;

@Slf4j
@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class UpdateReview {

    private final Long userId;
    private final String description;
    private final double rating;
    private final Instant updatedAt;
}
