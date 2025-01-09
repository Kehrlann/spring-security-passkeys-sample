package wf.garnier.demos.passkeys;

import wf.garnier.demos.passkeys.mail.ConsoleMailNotifier;
import wf.garnier.demos.passkeys.mail.MacOsMailNotifier;
import wf.garnier.demos.passkeys.mail.MailNotifier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Select a fake "email" service which shows notifications on MacOS when the
 * {@code terminal-notifier} program is present, and console messages on other platforms.
 */
@Configuration
class MailNotifierConfiguration {

	@Bean
	public MailNotifier mailNotifier() {
		if (MacOsMailNotifier.isSupported()) {
			return new MacOsMailNotifier();
		}
		else {
			return new ConsoleMailNotifier();
		}
	}

}
