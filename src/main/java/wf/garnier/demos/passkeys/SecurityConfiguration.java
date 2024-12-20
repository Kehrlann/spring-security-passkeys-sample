package wf.garnier.demos.passkeys;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
class SecurityConfiguration {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
			.webAuthn(passkeys -> passkeys.rpName("Spring Security Relying Party")
				.rpId("localhost")
				.allowedOrigins("http://localhost:8080"))
			.formLogin(login -> {
				login.loginPage("/login");
				login.permitAll();
			})
			.logout(logout -> logout.logoutSuccessUrl("/login"))
			.authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
			.build();
	}

}
