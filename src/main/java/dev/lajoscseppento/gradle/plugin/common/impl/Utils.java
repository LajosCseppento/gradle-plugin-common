package dev.lajoscseppento.gradle.plugin.common.impl;

import javax.annotation.Nullable;
import lombok.experimental.UtilityClass;

/** The must-have blob. At least internal (for now)... */
@UtilityClass
public class Utils {
  private final String UNSPECIFIED = "unspecified";

  /**
   * Returns true if the given value is null or empty.
   *
   * @param value the value to check
   * @return true if the given value is null or empty
   */
  public boolean isUnspecified(Object value) {
    if (value == null) {
      return true;
    } else {
      String valueStr = value.toString().trim();
      return valueStr.isEmpty() || UNSPECIFIED.equals(valueStr);
    }
  }

  /**
   * Trims the given string value and returns null if it is empty.
   *
   * @param value the string to trim
   * @return the trimmed string or null if it is empty
   */
  @Nullable
  public String trimToNull(String value) {
    if (value == null) {
      return null;
    } else {
      String str = value.trim();
      return str.isEmpty() ? null : str;
    }
  }
}
