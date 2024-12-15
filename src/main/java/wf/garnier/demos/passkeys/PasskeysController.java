package wf.garnier.demos.passkeys;

import java.util.List;

import wf.garnier.demos.passkeys.webauthn.AppCredentialsRecordRepository;
import wf.garnier.demos.passkeys.webauthn.PublicKeyUserRepository;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class PasskeysController {

	// Hello world page
	// login page
	// register page
	// login processsing page... ???

	private final AppCredentialsRecordRepository appCredentialsRecordRepository;

	private final PublicKeyUserRepository publicKeyUserRepository;

	PasskeysController(AppCredentialsRecordRepository appCredentialsRecordRepository,
			PublicKeyUserRepository publicKeyUserRepository) {
		this.appCredentialsRecordRepository = appCredentialsRecordRepository;
		this.publicKeyUserRepository = publicKeyUserRepository;
	}

	@GetMapping("/")
	public String index(Model model, Authentication authentication) {
		var pkUser = publicKeyUserRepository.findByUsername(authentication.getName());
		if (pkUser != null) {
			var passkeys = this.appCredentialsRecordRepository.findAllByUserEntityUserId(pkUser.getId().getBytes());
			model.addAttribute("passkeys", passkeys);
		} else {
			model.addAttribute("passkeys", List.of());
		}
		return "index";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

}
