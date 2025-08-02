plugins {
	java
	id("org.springframework.boot") version "3.1.1"
	id("io.spring.dependency-management") version "1.1.0"
}

group = "com.vdv"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator")
//	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
//	implementation("org.springframework.boot:spring-boot-starter-data-rest")
//	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.apache.commons:commons-lang3")
	implementation("org.apache.poi:poi:5.2.3")
	implementation("org.apache.poi:poi-ooxml:5.2.3")
	implementation("org.apache.poi:poi-ooxml-lite:5.2.3")

	//swagger
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")

//	implementation("com.google.code.gson:gson:2.10.1")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
//	developmentOnly("org.springframework.boot:spring-boot-docker-compose")
	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
