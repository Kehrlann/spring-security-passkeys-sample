package wf.garnier.demos.passkeys;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.webauthn.management.PublicKeyCredentialUserEntityRepository;
import org.springframework.security.web.webauthn.management.UserCredentialRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class PasskeysController {

	// Hello world page
	// login page
	// register page
	// login processsing page... ???

	private final UserCredentialRepository credentialsRepository;

	private final PublicKeyCredentialUserEntityRepository publicKeyUserRepository;

	PasskeysController(UserCredentialRepository credentialsRepository,
			PublicKeyCredentialUserEntityRepository publicKeyUserRepository) {
		this.credentialsRepository = credentialsRepository;
		this.publicKeyUserRepository = publicKeyUserRepository;
	}

	@GetMapping("/")
	public String index(Model model, Authentication authentication) {
		var pkUser = publicKeyUserRepository.findByUsername(authentication.getName());
		if (pkUser != null) {
			var passkeys = this.credentialsRepository.findByUserId(pkUser.getId());
			model.addAttribute("passkeys", passkeys);
		}
		else {
			model.addAttribute("passkeys", List.of());
		}
		return "index";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

}
