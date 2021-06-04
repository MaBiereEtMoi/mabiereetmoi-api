package com.mabiereetmoi.api.beer;

import com.mabiereetmoi.api.converter.AbstractConverter;
import com.mabiereetmoi.api.favoriteBeer.FavoriteBeerId;
import com.mabiereetmoi.api.favoriteBeer.FavoriteBeerService;
import com.mabiereetmoi.api.rating.Rating;
import com.mabiereetmoi.api.rating.RatingConverter;
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
    private final RatingConverter ratingConverter;

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
                .ratings(ratingConverter.listEntityToDto(ratingService.getRatingsByBeer(entity.getIdBeer())))
                .createDate(entity.getCreateDate())
                .picture(entity.getPicture())
                .degreeAlcohol(entity.getDegreeAlcohol())
                .idBeer(entity.getIdBeer())
                .description(entity.getDescription())
                .nameBeer(entity.getNameBeer())
                .note_avg(ratingService.getAvgByBeer(entity.getIdBeer()))
                .image(entity.getImage())
                .isFavorite(favoriteBeerService.isFavorite(favoriteBeerId))
                .nbFavorites(favoriteBeerService.getNbFavorite(entity.getIdBeer()))
                .myRate(ratingConverter.entityToDto(ratingService.getRating(ratingId))).build();
    }

    @Override
    public Beer dtoToEntity(BeerDto dto) {
        return null;
    }
}
