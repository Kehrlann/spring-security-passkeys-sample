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


	@GetMapping("/custom-login")
	public String login() {
		return "login";
	}

}
