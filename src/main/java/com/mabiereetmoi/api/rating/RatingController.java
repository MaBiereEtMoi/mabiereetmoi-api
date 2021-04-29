package com.mabiereetmoi.api.rating;

import com.mabiereetmoi.api.security.SecurityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/rating")
public class RatingController {

    private final RatingService ratingService;
    private final SecurityService securityService;

    @PostMapping
    public ResponseEntity<Rating> saveRating(@RequestBody Rating rating) {
        rating.setUser(securityService.getUser());
        return ResponseEntity.ok(ratingService.saveRating(rating));
    }

}
