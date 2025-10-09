package wf.garnier.demos.passkeys;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class PasskeysController {


	@GetMapping("/custom-login")
	public String login() {
		return "login";
	}

}
