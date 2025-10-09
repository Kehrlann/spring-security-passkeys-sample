package wf.garnier.demos.passkeys;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
class SecurityConfiguration {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		//@formatter:off
		return http
				.authorizeHttpRequests(auth -> {
					auth.requestMatchers("/custom-login*").permitAll();
					auth.requestMatchers("/favicon.ico").permitAll();
					auth.requestMatchers("/error").permitAll();
					auth.anyRequest().authenticated();
				})
                .formLogin(Customizer.withDefaults())
				.logout(logout -> logout.logoutSuccessUrl("/login"))
				.build();
		//@formatter:on
	}

	@Bean
	UserDetailsService userDetailsService(DataSource dataSource) {
		return new JdbcUserDetailsManager(dataSource);
	}

}
