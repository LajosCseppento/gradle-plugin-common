# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

- Upgrade to Gradle 8.4 and Java 17
- Improve null handling for primitive-valued system properties

## [0.4.0] - 2023-04-25

### Changed

- Upgrade to Ruthless 0.7.0, Gradle 7.6.1, Java 11
- Transform `GradleVersion` utility into `CurrentGradleVersion` to avoid confusion with `org.gradle.util.GradleVersion`. Also removed unused methods.

## [0.3.0] - 2022-12-17

### Changed

- Upgrade to Gradle 7.5.1

## [0.2.1] - 2022-07-17

### Changed

- Make ObjectSystemProperty constructors public

## [0.2.0] - 2022-07-17

### Added

- Helpers for parsing system properties

## [0.1.2] - 2022-07-05

### Added

- Java 8 compatibility

## [0.1.1] - 2022-06-02

### Fixed

- Rename `GradleVersion.from(Settings)` to `GradleVersion.of(Settings)`

## [0.1.0] - 2022-06-02

### Added

- `GradleVersion`
- `VersionComparator`

[Unreleased]: https://github.com/LajosCseppento/gradle-plugin-common/compare/v0.4.0...HEAD

[0.4.0]: https://github.com/LajosCseppento/gradle-plugin-common/releases/tag/v0.4.0

[0.3.0]: https://github.com/LajosCseppento/gradle-plugin-common/releases/tag/v0.3.0

[0.2.1]: https://github.com/LajosCseppento/gradle-plugin-common/releases/tag/v0.2.1

[0.2.0]: https://github.com/LajosCseppento/gradle-plugin-common/releases/tag/v0.2.0

[0.1.2]: https://github.com/LajosCseppento/gradle-plugin-common/releases/tag/v0.1.2

[0.1.1]: https://github.com/LajosCseppento/gradle-plugin-common/releases/tag/v0.1.1

[0.1.0]: https://github.com/LajosCseppento/gradle-plugin-common/releases/tag/v0.1.0
