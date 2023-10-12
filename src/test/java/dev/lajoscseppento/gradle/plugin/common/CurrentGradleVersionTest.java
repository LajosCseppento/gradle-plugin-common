package dev.lajoscseppento.gradle.plugin.common;

import static org.assertj.core.api.Assertions.*;

import org.gradle.api.GradleException;
import org.gradle.util.GradleVersion;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CurrentGradleVersionTest {
  @ParameterizedTest
  @CsvSource({"6.9,7.4.2", "7.4.1,7.4.2"})
  void controlTestNotEqual(String v1, String v2) {
    var gv1 = GradleVersion.version(v1);
    var gv2 = GradleVersion.version(v2);

    assertThat(gv1).isLessThan(gv2);
    assertThat(gv2).isGreaterThan(gv1);
  }

  @ParameterizedTest
  @CsvSource({"6.9,6.9", "7.4.2,7.4.2"})
  void controlTestEqual(String v1, String v2) {
    var gv1 = GradleVersion.version(v1);
    var gv2 = GradleVersion.version(v2);

    assertThat(gv1).isEqualByComparingTo(gv2);
    assertThat(gv2).isEqualByComparingTo(gv1);
  }

  @ParameterizedTest
  @CsvSource({"7.4.2", "7.6.1"})
  void testRequireAtLeastDoesNotThrowWhenNotOlder(String minimumVersion) {
    assertThatNoException().isThrownBy(() -> CurrentGradleVersion.requireAtLeast(minimumVersion));
  }

  @ParameterizedTest
  @CsvSource({"8.5", "8.5.1"})
  void testRequireAtLeastThrowsWhenOlder(String minimumVersion) {
    assertThatThrownBy(() -> CurrentGradleVersion.requireAtLeast(minimumVersion))
        .isExactlyInstanceOf(GradleException.class)
        .hasMessage(
            "Gradle version %s is too old, please use %s at least.",
            GradleVersion.current().getVersion(), minimumVersion);
  }
}
