package wf.garnier.demos.passkeys;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface AppUserRepository extends CrudRepository<AppUser, UUID> {

	Optional<AppUser> findAppUserByUsername(String username);

}
