package com.mabiereetmoi.api.rating;

import com.mabiereetmoi.api.beer.Beer;
import com.mabiereetmoi.api.comment.Comment;
import com.mabiereetmoi.api.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@IdClass(RatingId.class)
public class Rating {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "beer_id")
    private Beer beer;

    @ManyToMany
    private Set<User> like;

    private Double rating;
    private String message;
    private Long createdAt;

}
