package com.academy.ticketservice.util.mapper;

import java.util.List;

public interface MapperInterface<D, E> {

    E mapToEntity(D dto, Class<?> entity);

    D mapToDto(E entity, Class<?> dto);

    List<D> listToDto(List<E> listOfEntities, Class<?> dto);
}
