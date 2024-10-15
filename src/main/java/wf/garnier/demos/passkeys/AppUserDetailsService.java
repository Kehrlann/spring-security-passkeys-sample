package wf.garnier.demos.passkeys;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class AppUserDetailsService implements UserDetailsService {

	private final AppUserRepository repository;

	public AppUserDetailsService(AppUserRepository repository) {
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return repository.findAppUserByUsername(username)
			.orElseThrow(() -> new UsernameNotFoundException("Could not find user with name " + username));
	}

}
