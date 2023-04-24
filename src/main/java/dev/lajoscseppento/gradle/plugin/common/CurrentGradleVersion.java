package dev.lajoscseppento.gradle.plugin.common;

import lombok.NonNull;
import lombok.experimental.UtilityClass;
import org.gradle.api.GradleException;
import org.gradle.util.GradleVersion;

/** Provides utilities for checking the Gradle version. */
@UtilityClass
public class CurrentGradleVersion {

  public void requireAtLeast(@NonNull String minimumVersion) {
    requireAtLeast(GradleVersion.version(minimumVersion));
  }

  public void requireAtLeast(@NonNull GradleVersion minimumVersion) {
    GradleVersion currentVersion = GradleVersion.current();

    if (GradleVersion.current().compareTo(minimumVersion) < 0) {
      String msg =
          String.format(
              "Gradle version %s is too old, please use %s at least.",
              currentVersion.getVersion(), minimumVersion.getVersion());
      throw new GradleException(msg);
    }
  }
}
