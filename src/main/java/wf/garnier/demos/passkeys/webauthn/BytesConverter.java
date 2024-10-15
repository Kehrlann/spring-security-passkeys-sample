package wf.garnier.demos.passkeys.webauthn;

import jakarta.persistence.AttributeConverter;

import org.springframework.security.webauthn.api.Bytes;

class BytesConverter implements AttributeConverter<Bytes, byte[]> {

	@Override
	public byte[] convertToDatabaseColumn(Bytes attribute) {
		return attribute.getBytes();
	}

	@Override
	public Bytes convertToEntityAttribute(byte[] dbData) {
		return new Bytes(dbData);
	}

}
