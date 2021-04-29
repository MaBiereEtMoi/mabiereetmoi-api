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

    @OneToMany
    private List<Comment> comments;

    private Double rating;
    private String message;

}
