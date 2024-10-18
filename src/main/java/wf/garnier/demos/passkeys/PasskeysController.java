package wf.garnier.demos.passkeys;

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
		var passkeys = this.appCredentialsRecordRepository.findAllByUserEntityUserId(pkUser.getId().getBytes());
		model.addAttribute("passkeys", passkeys);
		return "index";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

}
