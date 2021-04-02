package com.mabiereetmoi.api.comment;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public Comment saveComment(@RequestBody Comment comment){
        return commentService.save(comment);
    }

    @GetMapping("/{id}")
    public Comment getCommentByid(@PathVariable Long id) {
        return commentService.findById(id);
    }
}
