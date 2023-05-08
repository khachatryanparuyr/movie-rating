package aca.demo.movierating.endpoint;

import aca.demo.movierating.review.Review;
import aca.demo.movierating.review.ReviewService;
import aca.demo.movierating.review.UpdateReview;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Optional;

@RestController
@RequestMapping("/movies/{id}")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/review")
    public ResponseEntity<Optional<Review>> readReview(@PathVariable Long id) {
        return ResponseEntity.ok().body(reviewService.getReviewRepository().findById(id));
    }

    @PostMapping
    public ResponseEntity<Review> crateReview(@RequestBody Review review) {
        reviewService.create(review);
        return ResponseEntity.ok().body(review);
    }

    @PutMapping("/update")
    public ResponseEntity<Review> updateReview(@PathVariable Long id, UpdateReview updateReview) {
        reviewService.update(id, updateReview);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Review> deleteReview(@PathVariable Long id) {
        reviewService.delete(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/search")
    public ResponseEntity<Review> searchReviews(@RequestParam(required = false) String description,
                                                @RequestParam(required = false) Instant updatedBefore,
                                                @RequestParam(required = false) Instant updatedAfter,
                                                @RequestParam(required = false) Long userId,
                                                @RequestParam(required = false) double ratingHigherThan,
                                                @RequestParam(required = false) double ratingLowerThan) {
        reviewService.search(description,updatedBefore,updatedAfter,userId,ratingHigherThan,ratingLowerThan);
        return ResponseEntity.accepted().build();
    }

}
