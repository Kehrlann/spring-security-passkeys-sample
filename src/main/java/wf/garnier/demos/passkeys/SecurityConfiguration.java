package wf.garnier.demos.passkeys;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.annotation.web.configurers.WebauthnConfigurer.webauthn;

@Configuration
class SecurityConfiguration {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
			.with(webauthn(),
					passkeys -> passkeys.rpName("Spring Security Relying Party")
						.rpId("localhost")
						.allowedOrigins("http://localhost:8080"))
			.formLogin(Customizer.withDefaults())
			.authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
			.build();
	}

}
