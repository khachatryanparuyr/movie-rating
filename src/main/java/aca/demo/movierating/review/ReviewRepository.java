package aca.demo.movierating.review;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class ReviewRepository {
    private List<Review> reviews = new ArrayList<>();

    public Optional<Review> findById(Long id) {
        return reviews.stream().filter(review -> review.getId().equals(id)).findFirst();
    }

}
