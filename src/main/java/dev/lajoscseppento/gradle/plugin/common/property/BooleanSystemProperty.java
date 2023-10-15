package dev.lajoscseppento.gradle.plugin.common.property;

import dev.lajoscseppento.gradle.plugin.common.property.impl.PrimitiveSystemProperty;
import java.util.function.Supplier;
import lombok.NonNull;

/**
 * Represents a boolean system property.
 *
 * <p>Case-ignored <code>"true"</code> and <code>1</code> are parsed as <code>true</code>,
 * case-ignored <code>"false"</code> and <code>0</code> are parsed as <code>false</code>. Other
 * values are considered invalid.
 *
 * <p>During parsing string values are trimmed.
 */
public class BooleanSystemProperty extends PrimitiveSystemProperty<Boolean> {
  /**
   * Creates a boolean system property.
   *
   * @param key the system property key
   * @param defaultValue the default value
   */
  public BooleanSystemProperty(@NonNull String key, boolean defaultValue) {
    super(key, defaultValue);
  }

  /**
   * Creates a boolean system property.
   *
   * @param key the system property key
   * @param defaultValueSupplier a {@link Supplier} providing the default value
   */
  public BooleanSystemProperty(
      @NonNull String key, @NonNull Supplier<Boolean> defaultValueSupplier) {
    super(key, defaultValueSupplier);
  }

  /**
   * Returns the value of the system property.
   *
   * @return the value of the system property or the default value if it is not set
   * @throws InvalidPropertyValueException if the default value would be returned, but it is null
   */
  public boolean get() {
    return getValueOrDefault();
  }

  @Override
  protected Boolean parse(@NonNull String value) {
    return switch (value.toLowerCase()) {
      case "true", "1" -> true;
      case "false", "0" -> false;
      default -> throw new InvalidPropertyValueException(
          "Cannot parse value of system property %s as boolean: %s".formatted(getKey(), value));
    };
  }
}
