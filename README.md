# spring-webauthn

Simple WebAuthN demo, using basic Spring code. This is intended to showcase how passkey and WebAuthN
registration and authentication work.

> ⚠️  This is a demo project, and MUST NOT be used as-is in production.

Pre-requisites:
- Java 17+
- Docker
- An authenticator (ex: Windows Hello, a Yubikey, a FIDO2-compliant phone authenticator, etc.)

Run this project:

```bash
./gradlew bootRun
```

Then navigate to [http://localhost:8080](http://localhost:8080). First, sign up for an account. You
may use any e-mail, as no real e-mail will be sent.

Then click "log in with e-mail", and check the console of the Spring Boot process. You should see a
link, click on it. This logs you in.

Once logged in, you may add as many Authenticators as you wish with "Register Passkey". Once you
have at least one authenticator registered, log out, and, on the main page, try clicking "Log in
with Passkey".
