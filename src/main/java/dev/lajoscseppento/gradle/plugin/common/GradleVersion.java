package dev.lajoscseppento.gradle.plugin.common;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.gradle.api.GradleException;
import org.gradle.api.Project;
import org.gradle.api.initialization.Settings;
import org.gradle.api.invocation.Gradle;

/** Provides utilities for checking the Gradle version. */
@RequiredArgsConstructor
public class GradleVersion {

  @NonNull @Getter private final String currentVersion;
  private final VersionComparator versionComparator = new VersionComparator();

  public boolean isGreaterThan(@NonNull String version) {
    return versionComparator.compare(version, currentVersion) < 0;
  }

  public boolean isGreaterThanOrEqualTo(@NonNull String version) {
    return versionComparator.compare(version, currentVersion) <= 0;
  }

  public boolean isLessThan(@NonNull String version) {
    return versionComparator.compare(currentVersion, version) < 0;
  }

  public boolean isLessThanOrEqualTo(@NonNull String version) {
    return versionComparator.compare(currentVersion, version) <= 0;
  }

  public void requireAtLeast(@NonNull String minimumVersion) {
    if (isLessThan(minimumVersion)) {
      String msg =
          String.format(
              "Gradle version %s is too old, please use %s at least.",
              currentVersion, minimumVersion);
      throw new GradleException(msg);
    }
  }

  public static GradleVersion of(@NonNull Gradle gradle) {
    return new GradleVersion(gradle.getGradleVersion());
  }

  public static GradleVersion of(@NonNull Project project) {
    return of(project.getGradle());
  }

  public static GradleVersion of(@NonNull Settings settings) {
    return of(settings.getGradle());
  }
}
