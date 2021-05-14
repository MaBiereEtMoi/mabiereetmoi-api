package com.mabiereetmoi.api.comment;

import com.mabiereetmoi.api.rating.Rating;
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

    public Comment save(Comment comment){
        return commentRepository.save(comment);
    }
}
