package com.mabiereetmoi.api.rating;

import com.mabiereetmoi.api.security.SecurityService;
import com.mabiereetmoi.api.user.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@AllArgsConstructor
@RequestMapping("/rating")
public class RatingController {

    private final RatingService ratingService;
    private final SecurityService securityService;
    private final RatingConverter ratingConverter;

    @PostMapping
    public ResponseEntity<RatingDto> saveRating(@RequestBody Rating rating) {
        if (rating.getUser() != null && !rating.getUser().getUid().equals(securityService.getUser().getUid())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        rating.setUser(securityService.getUser());
        rating.setCreatedAt(LocalDateTime.now().toEpochSecond(ZoneId.of("Europe/Paris").getRules().getOffset(LocalDateTime.now())));
        return ResponseEntity.ok(ratingConverter.entityToDto(ratingService.saveRating(rating)));
    }

    @PostMapping("/like/beer/{beerId}/user/{userId}")
    public ResponseEntity<RatingDto> likeRating(@PathVariable("beerId") Long beerId, @PathVariable("userId") String uid) {
        RatingId ratingId = new RatingId();
        ratingId.setUser(uid);
        ratingId.setBeer(beerId);
        User user = securityService.getUser();
        Rating rating = ratingService.likeRating(ratingId, user);
        if (rating == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(ratingConverter.entityToDto(rating));
    }

    @PostMapping("/dislike/beer/{beerId}/user/{userId}")
    public ResponseEntity<RatingDto> dislikeRating(@PathVariable("beerId") Long beerId, @PathVariable("userId") String uid) {
        RatingId ratingId = new RatingId();
        ratingId.setUser(uid);
        ratingId.setBeer(beerId);
        User user = securityService.getUser();
        Rating rating = ratingService.dislikeRating(ratingId, user.getUid());
        if (rating == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(ratingConverter.entityToDto(rating));
    }
}
