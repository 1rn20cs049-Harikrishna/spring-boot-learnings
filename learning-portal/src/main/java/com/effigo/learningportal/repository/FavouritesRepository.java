package com.effigo.learningportal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.effigo.learningportal.model.FavouritesEntity;

@Repository
public interface FavouritesRepository extends JpaRepository<FavouritesEntity, Long> {

	@Query(value = "SELECT * FROM favourites WHERE user_id = :uid AND course_id = :cid", nativeQuery = true)
	Optional<FavouritesEntity> findByUserIdAndCourseId(Long uid, Long cid);

}
