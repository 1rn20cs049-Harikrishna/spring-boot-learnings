package com.effigo.learningportal.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.effigo.learningportal.dto.UserDTO;
import com.effigo.learningportal.model.UserEntity;

@Mapper(componentModel = "spring" , uses = {UserDTO.class})
public interface UserPopulator {

	UserPopulator INSTANCE = Mappers.getMapper(UserPopulator.class);

//	@Mapping(target = "id", ignore = true)
//	@Mapping(target = "createdAt", ignore = true)
//	@Mapping(target = "updatedAt", ignore = true)
	UserEntity populateUser(UserDTO userDTO);
	
	

}
