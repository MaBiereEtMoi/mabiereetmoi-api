package com.mabiereetmoi.api.beer;

import com.mabiereetmoi.api.converter.AbstractConverter;
import com.mabiereetmoi.api.favoriteBeer.FavoriteBeerId;
import com.mabiereetmoi.api.favoriteBeer.FavoriteBeerService;
import com.mabiereetmoi.api.security.SecurityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class BeerConverter implements AbstractConverter<Beer, BeerDto> {

    private final FavoriteBeerService favoriteBeerService;
    private final SecurityService securityService;

    @Override
    public BeerDto entityToDto(Beer entity) {
        FavoriteBeerId favoriteBeerId = new FavoriteBeerId();
        favoriteBeerId.setBeer(entity.getId_beer());
        favoriteBeerId.setUser(securityService.getUser().getUid());
        return BeerDto.builder()
                .category(entity.getCategory())
                .comments(entity.getComments())
                .createDate(entity.getCreateDate())
                .degreeAlcohol(entity.getDegreeAlcohol())
                .id_beer(entity.getId_beer())
                .description(entity.getDescription())
                .nameBeer(entity.getNameBeer())
                .image(entity.getImage())
                .isFavorite(favoriteBeerService.isFavorite(favoriteBeerId)).build();
    }

    @Override
    public Beer dtoToEntity(BeerDto dto) {
        return null;
    }
}
