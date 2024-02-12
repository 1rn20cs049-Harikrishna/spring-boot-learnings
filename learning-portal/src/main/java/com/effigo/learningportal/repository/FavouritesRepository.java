package com.effigo.learningportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.effigo.learningportal.model.Favourites;

public interface FavouritesRepository extends JpaRepository<Favourites, Long> {
}
