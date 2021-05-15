package com.mabiereetmoi.api.comment;

import com.mabiereetmoi.api.converter.AbstractConverter;
import com.mabiereetmoi.api.security.SecurityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CommentConverter implements AbstractConverter<Comment, CommentDto> {

    private final SecurityService securityService;

    @Override
    public CommentDto entityToDto(Comment entity) {
        return CommentDto.builder()
                .idComment(entity.getIdComment())
                .createdAt(entity.getCreatedAt())
                .like(entity.getLike())
                .message(entity.getMessage())
                .user(entity.getUser())
                .nbLike(entity.getLike() == null ? 0 : entity.getLike().size())
                .alreadyLike(entity.getLike() != null && entity.getLike().stream().anyMatch((c -> c.getUid().equals(securityService.getUser().getUid()))))
                .isMyComment(securityService.getUser().getUid().equals(entity.getUser().getUid())).build();
    }

    @Override
    public Comment dtoToEntity(CommentDto dto) {
        return null;
    }
}
