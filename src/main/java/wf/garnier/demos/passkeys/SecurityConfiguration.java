package wf.garnier.demos.passkeys;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.ott.OneTimeTokenGenerationSuccessHandler;
import org.springframework.security.web.authentication.ott.RedirectOneTimeTokenGenerationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.webauthn.management.JdbcPublicKeyCredentialUserEntityRepository;
import org.springframework.security.web.webauthn.management.JdbcUserCredentialRepository;
import org.springframework.security.web.webauthn.management.PublicKeyCredentialUserEntityRepository;
import org.springframework.security.web.webauthn.management.UserCredentialRepository;

@Configuration
class SecurityConfiguration {

	OneTimeTokenGenerationSuccessHandler ottSuccessHandler = new RedirectOneTimeTokenGenerationSuccessHandler(
			"/login/ott");

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http, OneTimeTokenMailNotifier mailNotifier) throws Exception {
		//@formatter:off
		return http
				.authorizeHttpRequests(auth -> {
					auth.requestMatchers("/custom-login*").permitAll();
					auth.requestMatchers("/favicon.ico").permitAll();
					auth.requestMatchers("/error").permitAll();
					auth.anyRequest().authenticated();
				})
				.oneTimeTokenLogin(ott -> {
					ott.tokenGenerationSuccessHandler((request, response, authentication) -> {
						var token = authentication.getTokenValue();System.out.println("📩 Got token: " + token);
						mailNotifier.notify(authentication.getUsername(), "Demo app log in", token);
						System.out.println("🍪 Token: " + token);
						ottSuccessHandler.handle(request, response, authentication);
					});
				})
				.webAuthn(passkeys -> {
					passkeys.rpName("Spring Security Relying Party");
					passkeys.rpId("localhost");
					passkeys.allowedOrigins("http://localhost:8080");
				})
				.logout(logout -> logout.logoutSuccessUrl("/login"))
                .csrf(csrf -> {
                    // Ignore CSRF so we do not have to deal with it in pure JS implementations.
                    // Avoid doing this, instead following Spring Security's recommendations for CSRF:
                    // https://docs.spring.io/spring-security/reference/servlet/exploits/csrf.html#csrf-integration-javascript
                    csrf.ignoringRequestMatchers("/webauthn/**", "/login/webauthn");
                    // Instead you should be doing this:
                    var repo = new CookieCsrfTokenRepository();
                    repo.setCookieCustomizer(c -> c.httpOnly(false));
                    csrf.csrfTokenRepository(repo);
                    csrf.csrfTokenRequestHandler(new SpaCsrfTokenRequestHandler());
                })
				.build();
		//@formatter:on
	}

	@Bean
	UserDetailsService userDetailsService(DataSource dataSource) {
		return new JdbcUserDetailsManager(dataSource);
	}

	@Bean
	UserCredentialRepository passkeyRepo(JdbcOperations jdbcOperations) {
		return new JdbcUserCredentialRepository(jdbcOperations);
	}

	@Bean
	PublicKeyCredentialUserEntityRepository passkeyToUserRepo(JdbcOperations jdbcOperations) {
		return new JdbcPublicKeyCredentialUserEntityRepository(jdbcOperations);
	}

}
