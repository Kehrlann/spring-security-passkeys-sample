package wf.garnier.demos.passkeys.mail;

public class ConsoleMailNotifier implements MailNotifier {

	@Override
	public void notify(String title, String message, String link) {
		System.out.println("📥 %s: %s".formatted(title, message));
	}

}
