package com.mabiereetmoi.api.converter;

import java.util.List;
import java.util.stream.Collectors;

public interface AbstractConverter<E, D> {

    D entityToDto(E entity);

    E dtoToEntity(D dto);

    default List<D> listEntityToDto(List<E> entities){
        return entities.stream().map(this::entityToDto).collect(Collectors.toList());
    }

}
