package com.mabiereetmoi.api.comment;

public class CommentNotFoundException extends Exception{

    public CommentNotFoundException(Long commentId) {
        super("comment with id " + commentId + " not found");
    }

}
