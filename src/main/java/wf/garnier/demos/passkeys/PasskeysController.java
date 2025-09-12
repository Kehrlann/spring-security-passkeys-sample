package wf.garnier.demos.passkeys;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class PasskeysController {

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/custom-login")
	public String login() {
		return "login";
	}

}
