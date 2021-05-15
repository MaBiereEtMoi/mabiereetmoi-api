package com.mabiereetmoi.api.comment;

import com.mabiereetmoi.api.rating.Rating;
import com.mabiereetmoi.api.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue
    private Long idComment;

    @ManyToOne
    private User user;

    @ManyToOne
    private Rating rating;

    @ManyToMany
    private Set<User> like;

    private Long createdAt;

    private String message;
}
