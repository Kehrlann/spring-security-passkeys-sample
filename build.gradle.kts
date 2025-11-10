plugins {
	java
	id("org.springframework.boot") version "4.0.0-RC2"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "wf.garnier.demos"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(25)
	}
}
ext {
	extra["spring-security.version"] = "7.0.0-RC3"
}

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-mail")
	implementation("org.springframework.security:spring-security-webauthn")

	developmentOnly("org.springframework.boot:spring-boot-docker-compose")
	implementation("org.springframework.boot:spring-boot-devtools")

	runtimeOnly("org.postgresql:postgresql")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.boot:spring-boot-testcontainers")
	testImplementation("org.springframework.security:spring-security-test")
	testImplementation("org.testcontainers:junit-jupiter")
	testImplementation("org.testcontainers:postgresql")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

}

tasks.withType<Test> {
	useJUnitPlatform()
}
