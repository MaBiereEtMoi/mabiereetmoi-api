package com.mabiereetmoi.api.rating;

import com.mabiereetmoi.api.beer.Beer;
import com.mabiereetmoi.api.comment.Comment;
import com.mabiereetmoi.api.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RatingDto {

    private User user;
    private Beer beer;
    private List<Comment> comments;
    private Set<User> like;
    private Double rating;
    private String message;
    private Long createdAt;

    private int nbLike;
    private boolean alreadyLike;
    private boolean isMyComment;

}
