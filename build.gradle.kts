plugins {
	java
	id("org.springframework.boot") version "3.4.1"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "home"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
	maven("https://packages.confluent.io/maven/")
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.apache.kafka:kafka-streams")
	implementation("org.springframework.kafka:spring-kafka")
	implementation("org.apache.commons:commons-pool2:2.12.0")
	implementation("com.fasterxml.jackson.core:jackson-databind:2.18.2")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0")

	compileOnly("org.projectlombok:lombok")
	runtimeOnly("org.postgresql:postgresql")
	implementation("org.mapstruct:mapstruct:1.5.3.Final")

	annotationProcessor("org.mapstruct:mapstruct-processor:1.5.3.Final")
	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
	annotationProcessor("org.projectlombok:lombok")

	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}
	testImplementation("org.springframework.batch:spring-batch-test")
	testImplementation("org.springframework.kafka:spring-kafka-test")

	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
