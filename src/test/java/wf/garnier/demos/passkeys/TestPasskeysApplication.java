package wf.garnier.demos.passkeys;

import org.springframework.boot.SpringApplication;

public class TestPasskeysApplication {

	public static void main(String[] args) {
		SpringApplication.from(PasskeysApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
