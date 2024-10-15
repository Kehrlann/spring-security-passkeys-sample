package wf.garnier.demos.passkeys.webauthn;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.webauthn.api.Bytes;
import org.springframework.security.webauthn.api.PublicKeyCredentialUserEntity;
import org.springframework.security.webauthn.management.PublicKeyCredentialUserEntityRepository;

public interface PublicKeyUserRepository
		extends PublicKeyCredentialUserEntityRepository, CrudRepository<AppPublicKeyCredentialUserEntity, byte[]> {

	Optional<AppPublicKeyCredentialUserEntity> findByName(String name);

	/**
	 * Required to make the JPA method visible in
	 * {@link #save(PublicKeyCredentialUserEntity)}.
	 * @param userEntity must not be {@literal null}.
	 * @return -
	 */
	AppPublicKeyCredentialUserEntity save(AppPublicKeyCredentialUserEntity userEntity);

	@Override
	default void save(PublicKeyCredentialUserEntity userEntity) {
		AppPublicKeyCredentialUserEntity x = AppPublicKeyCredentialUserEntity.fromPublicKeyUserEntity(userEntity);
		this.save(x);
	}

	@Override
	default void delete(Bytes id) {
		deleteById(id.getBytes());
	}

	@Override
	default PublicKeyCredentialUserEntity findByUsername(String username) {
		return findByName(username).orElse(null);
	}

	@Override
	default PublicKeyCredentialUserEntity findById(Bytes id) {
		return findById(id.getBytes()).orElse(null);
	}

}
