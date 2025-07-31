import java.nio.charset.StandardCharsets

plugins {
	java
}

group = "me.MathiasMC"
version = "2.2.7"
description = "PvPLevels adds levels to your minecraft server"

repositories {
	mavenCentral()
	maven("https://repo.papermc.io/repository/maven-public/")
	maven("https://repo.extendedclip.com/releases/")
}

dependencies {
	compileOnly("io.papermc.paper:paper-api:1.21.8-R0.1-SNAPSHOT")
	compileOnly("me.clip:placeholderapi:2.11.6")
}

java {
	toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}

tasks {
	compileJava {
		options.encoding = StandardCharsets.UTF_8.name()
	}
}