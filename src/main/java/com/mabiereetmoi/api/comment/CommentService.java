package com.mabiereetmoi.api.comment;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public Comment findById(Long id){
        return commentRepository.findById(id).get();
    }

    public Comment save(Comment comment){
        return commentRepository.save(comment);
    }
}
