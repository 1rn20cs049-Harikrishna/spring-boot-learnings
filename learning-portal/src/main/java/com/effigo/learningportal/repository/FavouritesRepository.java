package com.effigo.learningportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.effigo.learningportal.model.Favourites;

@Repository
public interface FavouritesRepository extends JpaRepository<Favourites, Long> {
}
