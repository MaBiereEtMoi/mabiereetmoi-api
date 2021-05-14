package com.mabiereetmoi.api.rating;

import com.mabiereetmoi.api.user.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Double getAvgByBeer(Long beerId) {
        return ratingRepository.averageByBeer(beerId);
    }

    public Rating likeRating(RatingId ratingId, User user) {
        Rating rating = getRating(ratingId);
        if (rating == null) {
            return null;
        }
        rating.getLike().add(user);
        return ratingRepository.save(rating);
    }

    public Rating dislikeRating(RatingId ratingId, String uid) {
        Rating rating = getRating(ratingId);
        if (rating == null) {
            return null;
        }
        rating.getLike().removeIf(user -> user.getUid().equals(uid));
        return ratingRepository.save(rating);
    }

    public List<Rating> getRatingsByBeer(Long beerId) {
        return ratingRepository.findAllByBeerIdBeer(beerId);
    }

}
