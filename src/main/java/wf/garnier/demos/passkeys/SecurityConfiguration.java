package wf.garnier.demos.passkeys;

import javax.sql.DataSource;

import wf.garnier.demos.passkeys.mail.MailNotifier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.ott.OneTimeTokenGenerationSuccessHandler;
import org.springframework.security.web.authentication.ott.RedirectOneTimeTokenGenerationSuccessHandler;

@Configuration
class SecurityConfiguration {

	OneTimeTokenGenerationSuccessHandler ottSuccessHandler = new RedirectOneTimeTokenGenerationSuccessHandler(
			"/login/ott");

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http, MailNotifier mailNotifier) throws Exception {
		//@formatter:off
		return http
				.authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
				.formLogin(login -> {
					login.loginPage("/login");
					login.permitAll();
				})
				.oneTimeTokenLogin(ott -> {
					ott.tokenGenerationSuccessHandler((request, response, authentication) -> {
						var token = authentication.getTokenValue();System.out.println("📩 Got token: " + token);
						mailNotifier.notify("📩 Login", "You can log in with code " + token, "http://localhost:8080/login/ott?token=" + token);
						ottSuccessHandler.handle(request, response, authentication);
					});
				})
				.webAuthn(passkeys -> {
					passkeys.rpName("Spring Security Relying Party");
					passkeys.rpId("localhost");
					passkeys.allowedOrigins("http://localhost:8080");
				})
				.logout(logout -> logout.logoutSuccessUrl("/login"))
				.build();
		//@formatter:on
	}

	@Bean
	UserDetailsService userDetailsService(DataSource dataSource) {
		return new JdbcUserDetailsManager(dataSource);
	}

}
