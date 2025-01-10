package wf.garnier.demos.passkeys.webauthn;

import java.util.List;

import org.springframework.security.web.webauthn.api.Bytes;
import org.springframework.security.web.webauthn.api.CredentialRecord;
import org.springframework.security.web.webauthn.management.UserCredentialRepository;

public class AppUserCredentialRepository implements UserCredentialRepository {

	private final AppCredentialsRecordRepository delegate;

	public AppUserCredentialRepository(AppCredentialsRecordRepository repository) {
		this.delegate = repository;
	}

	@Override
	public void delete(Bytes credentialId) {
		this.delegate.deleteById(credentialId.getBytes());
	}

	@Override
	public void save(CredentialRecord credentialRecord) {
		this.delegate.save(AppCredentialsRecord.fromCredentialRecord(credentialRecord));
	}

	@Override
	public CredentialRecord findByCredentialId(Bytes credentialId) {
		return this.delegate.findById(credentialId.getBytes()).orElse(null);
	}

	@Override
	public List<CredentialRecord> findByUserId(Bytes userId) {
		return delegate.findAllByUserEntityUserId(userId.getBytes());
	}

}
