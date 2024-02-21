package com.effigo.learningportal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.effigo.learningportal.model.CourseEntity;
import com.effigo.learningportal.model.FavouritesEntity;

@Repository
public interface FavouritesRepository extends JpaRepository<FavouritesEntity, Long> {

//	 @Query("SELECT c FROM CourseEntity c INNER JOIN c.favourites f WHERE f.user.id = :userId")
	Optional<FavouritesEntity> findByUserIdAndCourseId(Long uid, Long cid);

	@Query("Select f from FavouritesEntity f Where f.user.id = :userId")
	List<CourseEntity> findAllByUserId(@Param("userId") Long userId);
}
