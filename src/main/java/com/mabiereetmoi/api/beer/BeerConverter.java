package com.mabiereetmoi.api.beer;

import com.mabiereetmoi.api.converter.AbstractConverter;
import com.mabiereetmoi.api.favoriteBeer.FavoriteBeerId;
import com.mabiereetmoi.api.favoriteBeer.FavoriteBeerService;
import com.mabiereetmoi.api.rating.Rating;
import com.mabiereetmoi.api.rating.RatingId;
import com.mabiereetmoi.api.rating.RatingService;
import com.mabiereetmoi.api.security.SecurityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class BeerConverter implements AbstractConverter<Beer, BeerDto> {

    private final FavoriteBeerService favoriteBeerService;
    private final SecurityService securityService;
    private final RatingService ratingService;

    @Override
    public BeerDto entityToDto(Beer entity) {
        FavoriteBeerId favoriteBeerId = new FavoriteBeerId();
        favoriteBeerId.setBeer(entity.getIdBeer());
        favoriteBeerId.setUser(securityService.getUser().getUid());
        RatingId ratingId = new RatingId();
        ratingId.setBeer(entity.getIdBeer());
        ratingId.setUser(securityService.getUser().getUid());
        return BeerDto.builder()
                .category(entity.getCategory())
                .comments(entity.getComments())
                .createDate(entity.getCreateDate())
                .degreeAlcohol(entity.getDegreeAlcohol())
                .idBeer(entity.getIdBeer())
                .description(entity.getDescription())
                .nameBeer(entity.getNameBeer())
                .image(entity.getImage())
                .isFavorite(favoriteBeerService.isFavorite(favoriteBeerId))
                .nbFavorites(favoriteBeerService.getNbFavorite(entity.getIdBeer()))
                .myRate(ratingService.getRating(ratingId)).build();
    }

    @Override
    public Beer dtoToEntity(BeerDto dto) {
        return null;
    }
}
