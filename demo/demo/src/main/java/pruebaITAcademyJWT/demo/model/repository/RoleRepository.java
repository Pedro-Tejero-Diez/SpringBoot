package pruebaITAcademyJWT.demo.model.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import pruebaITAcademyJWT.demo.model.domain.Role;


public interface RoleRepository extends MongoRepository<Role, Long> {
	//Optional<Role> findByName(Role name);
}