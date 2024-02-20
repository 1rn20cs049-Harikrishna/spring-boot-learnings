package com.effigo.learningportal.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.effigo.learningportal.dto.UserDTO;
import com.effigo.learningportal.model.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

//	@Mapping(target = "id", ignore = true)
//	@Mapping(target = "createdAt", ignore = true)
//	@Mapping(target = "updatedAt", ignore = true)
	UserEntity toEntity(UserDTO userDTO);

	UserDTO toDto(UserEntity userEntity);

}
