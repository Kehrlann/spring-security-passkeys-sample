package wf.garnier.demos.passkeys;

import javax.sql.DataSource;

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

	OneTimeTokenGenerationSuccessHandler DEFAULT_OTT_HANDLER = new RedirectOneTimeTokenGenerationSuccessHandler(
			"/login/ott");

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http, OneTimeTokenMailNotifier mailNotifier) throws Exception {
		return http.authorizeHttpRequests(auth -> {
			auth.requestMatchers("/custom-login*").permitAll();
			auth.requestMatchers("/favicon.ico").permitAll();
			auth.requestMatchers("/error").permitAll();
			auth.anyRequest().authenticated();
		}).oneTimeTokenLogin(ott -> {
			ott.tokenGenerationSuccessHandler((request, response, authentication) -> {
				var token = authentication.getTokenValue();
				var email = authentication.getUsername();
				mailNotifier.notify(email, "Demo app log in", token);
				System.out.println("📩 Got token: " + token);
				DEFAULT_OTT_HANDLER.handle(request, response, authentication);
			});
		})
			.logout(logout -> logout.logoutSuccessUrl("/login"))
			// This is a terrible idea. Don't do this.
			// It does make the demo faster, though.
			.csrf(csrf -> csrf.ignoringRequestMatchers("/webauthn/**", "/login/webauthn"))
			.build();
	}

	@Bean
	UserDetailsService userDetailsService(DataSource dataSource) {
		return new JdbcUserDetailsManager(dataSource);
	}

}
