package com.mabiereetmoi.api.rating;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RatingService {

    private final RatingRepository ratingRepository;

    public Rating saveRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    public Rating getRating(RatingId ratingId) {
        return ratingRepository.findById(ratingId).orElse(null);
    }

}
