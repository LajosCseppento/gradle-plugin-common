package dev.lajoscseppento.gradle.plugin.common;

import static org.assertj.core.api.Assertions.*;

import org.gradle.api.GradleException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GradleVersionTest {
  @ParameterizedTest
  @CsvSource({"6.9,7.4.2", "7.4.1,7.4.2"})
  void testNotEqual(String v1, String v2) {
    GradleVersion gradleVersion = new GradleVersion(v1);
    assertThat(gradleVersion.isGreaterThan(v2)).isFalse();
    assertThat(gradleVersion.isGreaterThanOrEqualTo(v2)).isFalse();
    assertThat(gradleVersion.isLessThan(v2)).isTrue();
    assertThat(gradleVersion.isLessThanOrEqualTo(v2)).isTrue();

    gradleVersion = new GradleVersion(v2);
    assertThat(gradleVersion.isGreaterThan(v1)).isTrue();
    assertThat(gradleVersion.isGreaterThanOrEqualTo(v1)).isTrue();
    assertThat(gradleVersion.isLessThan(v1)).isFalse();
    assertThat(gradleVersion.isLessThanOrEqualTo(v1)).isFalse();
  }

  @ParameterizedTest
  @CsvSource({"6.9,6.9", "7.4.2,7.4.2"})
  void testEqual(String v1, String v2) {
    GradleVersion gradleVersion = new GradleVersion(v1);
    assertThat(gradleVersion.isGreaterThan(v2)).isFalse();
    assertThat(gradleVersion.isGreaterThanOrEqualTo(v2)).isTrue();
    assertThat(gradleVersion.isLessThan(v2)).isFalse();
    assertThat(gradleVersion.isLessThanOrEqualTo(v2)).isTrue();

    gradleVersion = new GradleVersion(v2);
    assertThat(gradleVersion.isGreaterThan(v1)).isFalse();
    assertThat(gradleVersion.isGreaterThanOrEqualTo(v1)).isTrue();
    assertThat(gradleVersion.isLessThan(v1)).isFalse();
    assertThat(gradleVersion.isLessThanOrEqualTo(v1)).isTrue();
  }

  @ParameterizedTest
  @CsvSource({"7.4.2,6.9", "6.9,6.9"})
  @SuppressWarnings("squid:S2699") // Expected behaviour: no exception
  void testRequireAtLeastDoesNotThrowWhenNotOlder(String currentVersion, String minimumVersion) {
    GradleVersion gradleVersion = new GradleVersion(currentVersion);

    assertThatNoException().isThrownBy(() -> gradleVersion.requireAtLeast(minimumVersion));
  }

  @ParameterizedTest
  @CsvSource({"6.8,6.9", "6.9,7.4.2"})
  void testRequireAtLeastThrowsWhenOlder(String currentVersion, String minimumVersion) {
    GradleVersion gradleVersion = new GradleVersion(currentVersion);

    assertThatThrownBy(() -> gradleVersion.requireAtLeast(minimumVersion))
        .isExactlyInstanceOf(GradleException.class)
        .hasMessage(
            "Gradle version %s is too old, please use %s at least.",
            currentVersion, minimumVersion);
  }
}
