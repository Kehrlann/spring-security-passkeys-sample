package wf.garnier.demos.passkeys.webauthn;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

import jakarta.persistence.AttributeConverter;

import org.springframework.security.webauthn.api.AuthenticatorTransport;

class AuthenticatorTransportConverter implements AttributeConverter<Set<AuthenticatorTransport>, String> {

	@Override
	public String convertToDatabaseColumn(Set<AuthenticatorTransport> attribute) {
		if (attribute == null) {
			return null;
		}
		return attribute.stream().map(AuthenticatorTransport::getValue).collect(Collectors.joining(";"));
	}

	@Override
	public Set<AuthenticatorTransport> convertToEntityAttribute(String dbData) {
		if (dbData == null) {
			return Collections.emptySet();
		}
		return Arrays.stream(dbData.split(";")).map(AuthenticatorTransport::valueOf).collect(Collectors.toSet());
	}

}
