pluginManagement {
    plugins {
        id("dev.lajoscseppento.ruthless") version "0.8.0"
        id("org.sonarqube") version "4.4.1.3373"
    }
}

plugins {
    id("dev.lajoscseppento.ruthless")
    id("com.gradle.enterprise") version "+"
}

rootProject.name = "gradle-plugin-common"

gradleEnterprise {
    buildScan {
        termsOfServiceUrl = "https://gradle.com/terms-of-service"
        termsOfServiceAgree = "yes"
    }
}
