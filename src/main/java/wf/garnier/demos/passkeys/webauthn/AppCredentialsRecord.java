package wf.garnier.demos.passkeys.webauthn;

import java.time.Instant;
import java.util.Set;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.springframework.security.webauthn.api.AuthenticatorTransport;
import org.springframework.security.webauthn.api.Bytes;
import org.springframework.security.webauthn.api.CredentialRecord;
import org.springframework.security.webauthn.api.ImmutablePublicKeyCose;
import org.springframework.security.webauthn.api.PublicKeyCose;
import org.springframework.security.webauthn.api.PublicKeyCredentialType;

@Entity
@Table(name = "credentials_record")
public class AppCredentialsRecord implements CredentialRecord {

	@Id
	private byte[] credentialId;

	private long signatureCount;

	private boolean uvInitialized;

	private boolean backupEligible;

	private boolean backupState;

	private byte[] userEntityUserId;

	private byte[] attestationObject;

	private byte[] attestationClientDataJSON;

	private byte[] publicKeyCose;

	private String label;

	private Instant lastUsed;

	private Instant created;

	@Convert(converter = AuthenticatorTransportConverter.class)
	private Set<AuthenticatorTransport> transports;

	public static AppCredentialsRecord fromCredentialRecord(CredentialRecord record) {
		var result = new AppCredentialsRecord();
		result.credentialId = record.getCredentialId().getBytes();
		result.signatureCount = record.getSignatureCount();
		result.uvInitialized = record.isUvInitialized();
		result.backupEligible = record.isBackupEligible();
		result.backupState = record.isBackupState();
		result.userEntityUserId = record.getUserEntityUserId().getBytes();
		result.attestationObject = record.getAttestationObject().getBytes();
		result.attestationClientDataJSON = record.getAttestationClientDataJSON().getBytes();
		result.publicKeyCose = record.getPublicKey().getBytes();
		result.label = record.getLabel();
		result.lastUsed = record.getLastUsed();
		result.created = record.getCreated();
		result.transports = record.getTransports();
		return result;
	}

	@Override
	public PublicKeyCredentialType getCredentialType() {
		return PublicKeyCredentialType.PUBLIC_KEY;
	}

	@Override
	public PublicKeyCose getPublicKey() {
		return new ImmutablePublicKeyCose(publicKeyCose);
	}

	public void setPublicKeyCose(byte[] publicKeyCose) {
		this.publicKeyCose = publicKeyCose;
	}

	@Override
	public Set<AuthenticatorTransport> getTransports() {
		return transports;
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
		return uvInitialized;
	}

	public void setUvInitialized(boolean uvInitialized) {
		this.uvInitialized = uvInitialized;
	}

	@Override
	public boolean isBackupEligible() {
		return backupEligible;
	}

	public void setBackupEligible(boolean backupEligible) {
		this.backupEligible = backupEligible;
	}

	@Override
	public boolean isBackupState() {
		return backupState;
	}

	public void setBackupState(boolean backupState) {
		this.backupState = backupState;
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
		return new Bytes(attestationClientDataJSON);
	}

	public void setAttestationClientDataJSON(byte[] attestationClientDataJSON) {
		this.attestationClientDataJSON = attestationClientDataJSON;
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
