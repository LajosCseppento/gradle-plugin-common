package dev.lajoscseppento.gradle.plugin.common;

import lombok.NonNull;
import lombok.experimental.UtilityClass;
import org.gradle.api.GradleException;
import org.gradle.util.GradleVersion;

/** Provides utilities for checking the current Gradle version. */
@UtilityClass
public class CurrentGradleVersion {

  /**
   * Checks if the current Gradle version is at least the given version.
   *
   * @param minimumVersion the minimum version
   * @throws GradleException if the current Gradle version is lower than the given version
   */
  public void requireAtLeast(@NonNull String minimumVersion) {
    requireAtLeast(GradleVersion.version(minimumVersion));
  }

  /**
   * Checks if the current Gradle version is at least the given version.
   *
   * @param minimumVersion the minimum version
   * @throws GradleException if the current Gradle version is lower than the given version
   */
  public void requireAtLeast(@NonNull GradleVersion minimumVersion) {
    GradleVersion currentVersion = GradleVersion.current();

    if (GradleVersion.current().compareTo(minimumVersion) < 0) {
      String msg =
          "Gradle version %s is too old, please use %s at least."
              .formatted(currentVersion.getVersion(), minimumVersion.getVersion());
      throw new GradleException(msg);
    }
  }
}
