package com.mabiereetmoi.api.comment;

import com.mabiereetmoi.api.rating.Rating;
import com.mabiereetmoi.api.rating.RatingId;
import com.mabiereetmoi.api.rating.RatingService;
import com.mabiereetmoi.api.security.SecurityService;
import com.mabiereetmoi.api.user.User;
import com.mabiereetmoi.api.user.UserNotFoundException;
import com.mabiereetmoi.api.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@AllArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;
    private final RatingService ratingService;
    private final SecurityService securityService;
    private final UserService userService;
    private final CommentConverter commentConverter;

    @PostMapping("/beer/{beerId}/user/{uid}")
    public ResponseEntity<CommentDto> saveComment(@RequestBody String message, @PathVariable("beerId") Long beerId, @PathVariable("uid") String uid) throws UserNotFoundException {
        RatingId ratingId = new RatingId();
        ratingId.setBeer(beerId);
        ratingId.setUser(uid);
        Rating rating = ratingService.getRating(ratingId);
        if (rating == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(commentConverter.entityToDto(commentService.save(Comment.builder()
                .message(message)
                .createdAt(LocalDateTime.now().toEpochSecond(ZoneId.of("Europe/Paris").getRules().getOffset(LocalDateTime.now())))
                .user(userService.findByUid(securityService.getUser().getUid()))
                .rating(rating).build())));
    }

    @GetMapping("/{id}")
    public Comment getCommentByid(@PathVariable Long id) {
        return commentService.findById(id);
    }

    @PostMapping("/like/{commentId}")
    public ResponseEntity<CommentDto> likeComment(@PathVariable("commentId") Long commentId) throws CommentNotFoundException {
        return ResponseEntity.ok(commentConverter.entityToDto(commentService.likeComment(commentId, securityService.getUser())));
    }

    @PostMapping("/dislike/{commentId}")
    public ResponseEntity<CommentDto> dislikeComment(@PathVariable("commentId") Long commentId) throws CommentNotFoundException {
        return ResponseEntity.ok(commentConverter.entityToDto(commentService.dislikeComment(commentId, securityService.getUser().getUid())));
    }

}
