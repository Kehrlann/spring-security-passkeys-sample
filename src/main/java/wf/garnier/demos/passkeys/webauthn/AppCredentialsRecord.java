package wf.garnier.demos.passkeys.webauthn;

import java.time.Instant;
import java.util.Collections;
import java.util.Set;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.springframework.security.web.webauthn.api.AuthenticatorTransport;
import org.springframework.security.web.webauthn.api.Bytes;
import org.springframework.security.web.webauthn.api.CredentialRecord;
import org.springframework.security.web.webauthn.api.PublicKeyCose;
import org.springframework.security.web.webauthn.api.PublicKeyCredentialType;

@Entity
@Table(name = "credentials_record")
public class AppCredentialsRecord implements CredentialRecord {

	@Id
	private byte[] credentialId;

	private long signatureCount;

	private byte[] userEntityUserId;

	private byte[] attestationObject;

	private String label;

	private Instant lastUsed;

	private Instant created;

	public static AppCredentialsRecord fromCredentialRecord(CredentialRecord record) {
		var result = new AppCredentialsRecord();
		result.credentialId = record.getCredentialId().getBytes();
		result.signatureCount = record.getSignatureCount();
		result.userEntityUserId = record.getUserEntityUserId().getBytes();
		result.attestationObject = record.getAttestationObject().getBytes();
		result.label = record.getLabel();
		result.lastUsed = record.getLastUsed();
		result.created = record.getCreated();
		return result;
	}

	@Override
	public PublicKeyCredentialType getCredentialType() {
		return PublicKeyCredentialType.PUBLIC_KEY;
	}

	@Override
	public PublicKeyCose getPublicKey() {
		return null;
	}

	@Override
	public Set<AuthenticatorTransport> getTransports() {
		return Collections.emptySet();
	}

	@Override
	public Bytes getCredentialId() {
		return new Bytes(credentialId);
	}

	public void setCredentialId(byte[] credentialId) {
		this.credentialId = credentialId;
	}

	@Override
	public long getSignatureCount() {
		return signatureCount;
	}

	public void setSignatureCount(long signatureCount) {
		this.signatureCount = signatureCount;
	}

	@Override
	public boolean isUvInitialized() {
		return false;
	}

	@Override
	public boolean isBackupEligible() {
		return false;
	}

	@Override
	public boolean isBackupState() {
		return false;
	}

	@Override
	public Bytes getUserEntityUserId() {
		return new Bytes(userEntityUserId);
	}

	public void setUserEntityUserId(byte[] userEntityUserId) {
		this.userEntityUserId = userEntityUserId;
	}

	@Override
	public Bytes getAttestationObject() {
		return new Bytes(attestationObject);
	}

	public void setAttestationObject(byte[] attestationObject) {
		this.attestationObject = attestationObject;
	}

	@Override
	public Bytes getAttestationClientDataJSON() {
		return null;
	}

	@Override
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public Instant getLastUsed() {
		return lastUsed;
	}

	public void setLastUsed(Instant lastUsed) {
		this.lastUsed = lastUsed;
	}

	@Override
	public Instant getCreated() {
		return created;
	}

	public void setCreated(Instant created) {
		this.created = created;
	}

}
