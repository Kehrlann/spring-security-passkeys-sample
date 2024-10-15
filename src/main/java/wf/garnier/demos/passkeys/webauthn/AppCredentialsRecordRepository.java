package wf.garnier.demos.passkeys.webauthn;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.webauthn.api.Bytes;
import org.springframework.security.webauthn.api.CredentialRecord;
import org.springframework.security.webauthn.management.UserCredentialRepository;

public interface AppCredentialsRecordRepository
		extends UserCredentialRepository, CrudRepository<AppCredentialsRecord, byte[]> {

	List<CredentialRecord> findAllByUserEntityUserId(byte[] userId);

	AppCredentialsRecord save(AppCredentialsRecord record);

	@Override
	default List<CredentialRecord> findByUserId(Bytes userId) {
		return this.findAllByUserEntityUserId(userId.getBytes());
	}

	@Override
	default CredentialRecord findByCredentialId(Bytes credentialId) {
		return this.findById(credentialId.getBytes()).orElse(null);
	}

	@Override
	default void save(CredentialRecord credentialRecord) {
		this.save(AppCredentialsRecord.fromCredentialRecord(credentialRecord));
	}

	@Override
	default void delete(Bytes credentialId) {
		this.deleteById(credentialId.getBytes());
	}

}
