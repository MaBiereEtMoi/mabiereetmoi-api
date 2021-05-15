package com.mabiereetmoi.api.comment;

import com.mabiereetmoi.api.rating.Rating;
import com.mabiereetmoi.api.rating.RatingId;
import com.mabiereetmoi.api.user.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public Comment findById(Long id){
        return commentRepository.findById(id).get();
    }

    public List<Comment> findCommentsByRating(Rating rating) {
        return commentRepository.findAllByRating(rating);
    }

    public Comment getCommentById(Long commentId) throws CommentNotFoundException {
        return commentRepository.findById(commentId).orElseThrow(() -> new CommentNotFoundException(commentId));
    }

    public Comment save(Comment comment){
        return commentRepository.save(comment);
    }

    public Comment likeComment(Long commentId, User user) throws CommentNotFoundException {
        Comment comment = this.getCommentById(commentId);
        comment.getLike().add(user);
        return commentRepository.save(comment);
    }

    public Comment dislikeComment(Long commentId, String uid) throws CommentNotFoundException {
        Comment comment = this.getCommentById(commentId);
        comment.getLike().removeIf(user -> user.getUid().equals(uid));
        return commentRepository.save(comment);
    }

}
