package wf.garnier.demos.passkeys;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class OneTimeTokenMailNotifier {

	private final JavaMailSenderImpl mailSender;

	private final HttpServletRequest currentRequest;

	public OneTimeTokenMailNotifier(JavaMailSenderImpl mailSender, HttpServletRequest httpServletRequest) {
		this.mailSender = mailSender;
		this.currentRequest = httpServletRequest;
	}

	public void notify(String address, String title, String token) {
		var link = UriComponentsBuilder.fromUriString(UrlUtils.buildFullRequestUrl(currentRequest))
			.replacePath("/login/ott")
			.replaceQuery(null)
			.fragment(null)
			.queryParam("token", token)
			.toUriString();

		var message = mailSender.createMimeMessage();
		try {
			message.setFrom("spring-security@example.com");
			message.addRecipients(Message.RecipientType.TO, address);
			message.setSubject(title);
			message.setText("""
					<!DOCTYPE html>
					<html lang="en">
					<body>
					    <h1>Your one-time-token</h1>
					    <p>
					    	You tried to log-in using a one-time token. Please paste
					    	the following token in the app:
					    </p>
					    <h2>%s</h2>
						<p>
							Alternatively, you can log-in using the following link:
						</p>
						<p><a href="%s" target="_blank">%s</a></p>
					</body>
					</html>
					""".formatted(token, link, link), "UTF-8", "html");
		}
		catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		mailSender.send(message);
	}

}
