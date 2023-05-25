package com.ITAcademy.demoJWTSQL.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ITAcademy.demoJWTSQL.domain.models.ERole;
import com.ITAcademy.demoJWTSQL.domain.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Optional<Role> findByName(ERole name);

}
