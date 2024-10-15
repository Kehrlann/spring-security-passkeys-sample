package wf.garnier.demos.passkeys.webauthn;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.springframework.security.webauthn.api.Bytes;
import org.springframework.security.webauthn.api.PublicKeyCredentialUserEntity;

@Entity
@Table(name = "public_key_user")
public class AppPublicKeyCredentialUserEntity implements PublicKeyCredentialUserEntity {

	@Id
	private byte[] id;

	private String name;

	private String displayName;

	public static AppPublicKeyCredentialUserEntity fromPublicKeyUserEntity(PublicKeyCredentialUserEntity userEntity) {
		var result = new AppPublicKeyCredentialUserEntity();
		result.setId(userEntity.getId().getBytes());
		result.setName(userEntity.getName());
		result.setDisplayName(userEntity.getDisplayName());
		return result;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Bytes getId() {
		return new Bytes(id);
	}

	public void setId(byte[] id) {
		this.id = id;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

}
