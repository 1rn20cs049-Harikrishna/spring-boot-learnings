package com.effigo.learningportal.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.effigo.learningportal.dto.CourseDTO;
import com.effigo.learningportal.model.CourseEntity;

@Mapper
public interface CoursePopulator {
	CoursePopulator INSTANCE = Mappers.getMapper(CoursePopulator.class);

	@Mappings({ @Mapping(source = "courseCategory.id", target = "courseCategoryId"),
			@Mapping(source = "publisher.id", target = "publisherId") })
	CourseDTO CourseEntityToDto(CourseEntity courseEntity);

	@Mappings({ @Mapping(source = "courseCategoryId", target = "courseCategory.id"),
			@Mapping(source = "publisherId", target = "publisher.id"),
			@Mapping(source = "enrollments", target = "enrollments"),
			@Mapping(source = "favourites", target = "favourites") })
	CourseEntity CourseDtoToEntity(CourseDTO dto);

}
