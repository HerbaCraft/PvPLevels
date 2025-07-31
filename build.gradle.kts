plugins {
	java
	id("xyz.jpenilla.resource-factory-bukkit-convention") version "1.3.0"
}

group = "me.MathiasMC"
version = "3.0.0-SNAPSHOT"
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
		options.encoding = Charsets.UTF_8.name()
	}
}

bukkitPluginYaml {
	main = "me.MathiasMC.PvPLevels.PvPLevels"
	authors = listOf("MathiasMC", "FabianAdrian")
	website = "https://github.com/herbacraft/pvplevels"
	softDepend = listOf("PlaceholderAPI")
	apiVersion = "1.21.8"
	commands {
		register("pvplevels") {
			description = "PvPLevels main command"
			aliases = listOf("pvpl")
		}
	}
	permissions {
		register("pvplevels.*") {
			description = "Access to use all pvplevels commands"
			children = mapOf(
				"pvplevels.player.*" to true,
				"pvplevels.admin.*" to true
			)
		}

		register("pvplevels.player.*") {
			description = "Access to use all player commands"
			children = mapOf(
				"pvplevels.player.help" to true,
				"pvplevels.player.stats" to true,
				"pvplevels.player.top" to true
			)
		}

		register("pvplevels.admin.*") {
			description = "Access to use all admin commands"
			children = mapOf(
				"pvplevels.admin.help" to true,
				"pvplevels.admin.reload" to true,
				"pvplevels.admin.broadcast" to true,
				"pvplevels.admin.message" to true,
				"pvplevels.admin.actionbar" to true,
				"pvplevels.admin.save" to true,
				"pvplevels.admin.reset" to true,
				"pvplevels.admin.xp" to true,
				"pvplevels.admin.level" to true,
				"pvplevels.admin.multiplier" to true,
				"pvplevels.admin.generate" to true
			)
		}

		register("pvplevels.player.help") {
			description = "Access to use help"
		}

		register("pvplevels.player.stats") {
			description = "Access to see stats"
		}

		register("pvplevels.player.top") {
			description = "Access to see top"
		}

		register("pvplevels.admin.help") {
			description = "Access to use help"
		}

		register("pvplevels.admin.reload") {
			description = "Access to use reload"
		}

		register("pvplevels.admin.broadcast") {
			description = "Access to use broadcast"
		}

		register("pvplevels.admin.message") {
			description = "Access to use message"
		}

		register("pvplevels.admin.actionbar") {
			description = "Access to use actionbar"
		}

		register("pvplevels.admin.save") {
			description = "Access to use save"
		}

		register("pvplevels.admin.reset") {
			description = "Access to use reset"
		}

		register("pvplevels.admin.xp") {
			description = "Access to use xp"
		}

		register("pvplevels.admin.level") {
			description = "Access to use level"
		}

		register("pvplevels.admin.multiplier") {
			description = "Access to use multiplier"
		}

		register("pvplevels.admin.generate") {
			description = "Access to use generate"
		}

	}
}