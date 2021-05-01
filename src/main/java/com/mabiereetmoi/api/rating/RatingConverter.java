package com.mabiereetmoi.api.rating;

import com.mabiereetmoi.api.converter.AbstractConverter;
import com.mabiereetmoi.api.security.SecurityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RatingConverter implements AbstractConverter<Rating, RatingDto> {

    private final SecurityService securityService;

    @Override
    public RatingDto entityToDto(Rating entity) {
        if (entity == null) {
            return null;
        }
        return RatingDto.builder()
                .beer(entity.getBeer())
                .comments(entity.getComments())
                .createdAt(entity.getCreatedAt())
                .like(entity.getLike())
                .message(entity.getMessage())
                .user(entity.getUser())
                .rating(entity.getRating())
                .nbLike(entity.getLike() == null ? 0 : entity.getLike().size())
                .alreadyLike(entity.getLike() != null && entity.getLike().stream().anyMatch((c -> c.getUid().equals(securityService.getUser().getUid()))))
                .isMyComment(entity.getUser().getUid().equals(securityService.getUser().getUid())).build();
    }

    @Override
    public Rating dtoToEntity(RatingDto dto) {
        return null;
    }
}
