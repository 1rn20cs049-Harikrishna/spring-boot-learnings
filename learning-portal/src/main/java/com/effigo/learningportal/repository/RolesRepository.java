package com.effigo.learningportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.effigo.learningportal.model.RolesEntity;

@Repository
public interface RolesRepository extends JpaRepository<RolesEntity, Long> {

	@Query(value = "SELECT * FROM roles WHERE id = :roleId", nativeQuery = true)
    RolesEntity getByRoleId(@Param("roleId") long roleId);

}
