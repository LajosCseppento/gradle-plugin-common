plugins {
    id("dev.lajoscseppento.ruthless.java-library")
    id("org.sonarqube") version "3.3"
}

ruthless.lombok()

java {
    withJavadocJar()
    withSourcesJar()
}

dependencies {
    api(gradleApi())
}
