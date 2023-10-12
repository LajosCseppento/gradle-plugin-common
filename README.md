# gradle-plugin-common

[![Release](https://img.shields.io/github/v/release/LajosCseppento/gradle-plugin-common)](https://github.com/LajosCseppento/gradle-plugin-common/releases)
[![Maven Central](https://img.shields.io/maven-central/v/dev.lajoscseppento.gradle/gradle-plugin-common)](https://search.maven.org/search?q=g:%22dev.lajoscseppento.gradle%22%20AND%20a:%22gradle-plugin-common%22)
[![CI](https://github.com/LajosCseppento/gradle-plugin-common/workflows/CI/badge.svg)](https://github.com/LajosCseppento/gradle-plugin-common/actions)
[![License](https://img.shields.io/github/license/LajosCseppento/gradle-plugin-common)](https://github.com/LajosCseppento/gradle-plugin-common/blob/main/LICENSE)

Shared code for Gradle plugins, such as [Ruthless](https://github.com/LajosCseppento/ruthless)
and [FancyDoc](https://github.com/LajosCseppento/fancydoc).

## Development Guide

### Release Procedure

1. Release commit: fix version, finalise change log (don't forget about the links in the bottom of
   the change log)
2. Check CI for success
3. Tag release on GitHub (draft)
4. Publish to Maven Central
    1. Run `./gradlew publishAllPublicationsToStagingRepository`
    2. Open https://oss.sonatype.org/#stagingRepositories
    3. Close staging repository
    4. Inspect contents
    5. Release
5. Publish release on GitHub
6. Bump version
7. Upgrade to recently released version (notably `fancydoc` and `ruthless`)
