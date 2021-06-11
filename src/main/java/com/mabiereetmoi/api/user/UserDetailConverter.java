package com.mabiereetmoi.api.user;

import com.mabiereetmoi.api.badge.BadgeService;
import com.mabiereetmoi.api.converter.AbstractConverter;
import com.mabiereetmoi.api.favoriteBeer.FavoriteBeerService;
import com.mabiereetmoi.api.historisation.HistorisationService;
import com.mabiereetmoi.api.rating.RatingConverter;
import com.mabiereetmoi.api.rating.RatingService;
import com.mabiereetmoi.api.security.SecurityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserDetailConverter implements AbstractConverter<User, UserDetailDto> {

    private final SecurityService securityService;
    private final HistorisationService historisationService;
    private final FavoriteBeerService favoriteBeerService;
    private final RatingService ratingService;
    private final RatingConverter ratingConverter;

    @Override
    public UserDetailDto entityToDto(User entity) {
        return UserDetailDto.builder()
                .email(entity.getEmail())
                .emailVerified(entity.isEmailVerified())
                .firstname(entity.getFirstname())
                .lastname(entity.getLastname())
                .issuer(entity.getIssuer())
                .picture(entity.getPicture())
                .uid(entity.getUid())
                .username(entity.getUsername())
                .isMyProfile(entity.getUid().equals(securityService.getUser().getUid()))
                .nbScan(historisationService.countAllByUserUid(entity.getUid()))
                .nbBadge(0)
                .nbFavorite(favoriteBeerService.countAllByUserUid(entity.getUid()))
                .ratings(ratingConverter.listEntityToDto(ratingService.getRatingsByUserUid(entity.getUid())))
                .favoriteBeers(favoriteBeerService.getFavorites(entity.getUid()))
                .scannedBeers(historisationService.getHistorisationByUser(entity.getUid()))
                .badges(entity.getBadges())
                .build();
    }

    @Override
    public User dtoToEntity(UserDetailDto dto) {
        return null;
    }
}
