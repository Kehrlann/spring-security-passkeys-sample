package wf.garnier.demos.passkeys.mail;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class MacOsMailNotifier implements MailNotifier {

	@Override
	public void notify(String title, String message, String link) {
		try {
			Runtime.getRuntime().exec(new String[] {
					//@formatter:off
					"terminal-notifier",
					"-message", message,
					"-title", title,
					"-open", link,
					"-sound", "bell"
					//@formatter:on
			});
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static boolean isSupported() {
		try {
			var process = Runtime.getRuntime().exec(new String[] { "terminal-notifier", "-help" });
			int exitCode = process.onExit().get().exitValue();
			return exitCode == 0;
		}
		catch (IOException | InterruptedException | ExecutionException e) {
			return false;
		}
	}

}
