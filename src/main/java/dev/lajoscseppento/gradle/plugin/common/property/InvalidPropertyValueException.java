package dev.lajoscseppento.gradle.plugin.common.property;

/** Exception type for property helpers. */
public class InvalidPropertyValueException extends RuntimeException {
  /**
   * Creates an exception.
   *
   * @param message the message
   */
  public InvalidPropertyValueException(String message) {
    super(message);
  }

  /**
   * Creates an exception.
   *
   * @param message the message
   * @param cause the cause
   */
  public InvalidPropertyValueException(String message, Throwable cause) {
    super(message, cause);
  }
}
