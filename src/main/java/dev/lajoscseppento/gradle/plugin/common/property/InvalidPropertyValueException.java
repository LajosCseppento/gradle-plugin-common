package dev.lajoscseppento.gradle.plugin.common.property;

/** Exception type for property helpers. */
public class InvalidPropertyValueException extends RuntimeException {
  public InvalidPropertyValueException(String message) {
    super(message);
  }

  public InvalidPropertyValueException(String message, Throwable cause) {
    super(message, cause);
  }
}
