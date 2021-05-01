package com.mabiereetmoi.api.rating;

public class RatingNotFoundException extends Exception {

    public RatingNotFoundException(RatingId ratingId) {
        super("rating " + ratingId.getUser() + "/" + ratingId.getBeer() + " not found");
    }

}
