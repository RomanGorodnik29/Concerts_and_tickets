package com.academy.ticketservice.util.mapper.impl;

import com.academy.ticketservice.util.mapper.MapperInterface;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class Mapper<D, E> implements MapperInterface<D, E> {

    private final ModelMapper mapper;

    @Override
    @SuppressWarnings("unchecked")
    public E mapToEntity(D dto, Class<?> entity) {
        return Objects.isNull(dto) ? null : (E) mapper.map(dto, entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public D mapToDto(E entity, Class<?> dto) {
        return Objects.isNull(entity) ? null : (D) mapper.map(entity, dto);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<D> listToDto(List<E> listOfEntities, Class<?> dto) {
        return listOfEntities.stream()
                .map((entity) -> (D) mapper.map(entity, dto))
                .collect(Collectors.toList());
    }

}
