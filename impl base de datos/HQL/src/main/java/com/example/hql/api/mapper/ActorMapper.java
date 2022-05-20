package com.example.hql.api.mapper;

import com.example.hql.api.dto.ActorDto;
import com.example.hql.entity.Actor;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ActorMapper {
    Actor actorDtoToActor(ActorDto actorDto);

    ActorDto actorToActorDto(Actor actor);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateActorFromActorDto(ActorDto actorDto, @MappingTarget Actor actor);
}
