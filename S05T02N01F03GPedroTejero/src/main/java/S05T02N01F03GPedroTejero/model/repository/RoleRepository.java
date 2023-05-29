package S05T02N01F03GPedroTejero.model.repository;

import java.util.Optional;

import javax.management.relation.Role;

import org.springframework.data.mongodb.repository.MongoRepository;

import S05T02N01F03GPedroTejero.model.domain.Erole;

public interface RoleRepository extends MongoRepository<Role, String> {
	

		Optional<Role> findByName(Erole name);

}
