package com.mabiereetmoi.api.favoriteBeer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mabiereetmoi.api.beer.Beer;
import com.mabiereetmoi.api.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "favorite_beer")
@IdClass(FavoriteBeerId.class)
public class FavoriteBeer {

    @Id
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "beer_id")
    private Beer beer;

    private Long createdAt;

}
