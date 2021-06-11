package com.mabiereetmoi.api.user;

import com.mabiereetmoi.api.badge.Badge;
import com.mabiereetmoi.api.beer.Beer;
import com.mabiereetmoi.api.beer.BeerDto;
import com.mabiereetmoi.api.favoriteBeer.FavoriteBeer;
import com.mabiereetmoi.api.historisation.Historisation;
import com.mabiereetmoi.api.rating.RatingDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserDetailDto {
    private String uid;
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String picture;
    private String issuer;
    private boolean emailVerified;
    private boolean isMyProfile;
    private int nbScan;
    private int nbFavorite;
    private int nbBadge;
    private List<Historisation> scannedBeers;
    private List<BeerDto> favoriteBeers;
    private List<RatingDto> ratings;
    private List<Badge> badges;
}
