plugins {
    id("dev.lajoscseppento.ruthless.java-library")
    id("org.sonarqube") version "3.4.0.2513"
    `maven-publish`
    signing
}

ruthless.lombok()

dependencies {
    api(gradleApi())
}

val DESCRIPTION = "Shared code for Gradle plugins"
val WEBSITE = "https://github.com/LajosCseppento/gradle-plugin-common"
val POM_SCM_CONNECTION = "scm:git:git://github.com/LajosCseppento/gradle-plugin-common.git"
val POM_SCM_DEVELOPER_CONNECTION = "scm:git:ssh://git@github.com/LajosCseppento/gradle-plugin-common.git"
val POM_SCM_URL = "https://github.com/LajosCseppento/ruthless"

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])

            pom {
                name.set(project.name)
                description.set(DESCRIPTION)

                url.set(WEBSITE)

                licenses {
                    license {
                        name.set("Apache License, Version 2.0")
                        url.set("https://www.apache.org/licenses/LICENSE-2.0")
                    }
                }

                developers {
                    developer {
                        id.set("LajosCseppento")
                        name.set("Lajos Cseppentő")
                        url.set("https://www.lajoscseppento.dev")
                    }
                }

                scm {
                    connection.set(POM_SCM_CONNECTION)
                    developerConnection.set(POM_SCM_DEVELOPER_CONNECTION)
                    url.set(POM_SCM_URL)
                }
            }
        }
    }
}

if (hasProperty("ossrhUsername")) {
    publishing {
        repositories {
            val ossrhUsername: String by project
            val ossrhPassword: String by project

            maven {
                name = "snapshots"
                url = uri("https://oss.sonatype.org/content/repositories/snapshots")
                credentials {
                    username = ossrhUsername
                    password = ossrhPassword
                }
            }

            maven {
                name = "staging"
                url = uri("https://oss.sonatype.org/service/local/staging/deploy/maven2")
                credentials {
                    username = ossrhUsername
                    password = ossrhPassword
                }
            }
        }
    }
} else {
    logger.warn("Configure project without OSSRH publishing")
}

signing {
    if (hasProperty("signing.keyId")) {
        sign(publishing.publications)
    } else {
        logger.warn("Configure project without code signing")
    }
}
