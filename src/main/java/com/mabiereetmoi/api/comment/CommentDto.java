package com.mabiereetmoi.api.comment;

import com.mabiereetmoi.api.rating.Rating;
import com.mabiereetmoi.api.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDto {

    private Long idComment;
    private User user;
    private Rating rating;
    private Set<User> like;
    private Long createdAt;
    private String message;

    private int nbLike;
    private boolean alreadyLike;
    private boolean isMyComment;

}
