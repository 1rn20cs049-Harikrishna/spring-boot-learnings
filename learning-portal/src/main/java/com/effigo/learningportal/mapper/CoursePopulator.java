package com.effigo.learningportal.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.effigo.learningportal.dto.CourseDTO;
import com.effigo.learningportal.model.CourseEntity;

@Mapper
public interface CoursePopulator {
	CoursePopulator INSTANCE = Mappers.getMapper(CoursePopulator.class);

//	    @Mapping(target = "courseCategoryId", source = "courseCategory courseCategoryId.id")
//	    @Mapping(target = "publisherId", source = "userEntity.id")
	    CourseDTO CourseEntityToDto(CourseDTO courseDto);

	    CourseEntity CourseDtoToEntity(CourseDTO dto);

}

