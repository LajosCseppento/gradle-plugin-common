package dev.lajoscseppento.gradle.plugin.common.property;

import dev.lajoscseppento.gradle.plugin.common.property.impl.PrimitiveSystemProperty;
import java.util.function.Supplier;
import lombok.NonNull;

/**
 * Represents an <code>int</code> system property.
 *
 * <p>During parsing string values are trimmed.
 */
public class IntSystemProperty extends PrimitiveSystemProperty<Integer> {
  /**
   * Creates a boolean system property.
   *
   * @param key the system property key
   * @param defaultValue the default value
   */
  public IntSystemProperty(@NonNull String key, int defaultValue) {
    super(key, defaultValue);
  }

  /**
   * Creates a boolean system property.
   *
   * @param key the system property key
   * @param defaultValueSupplier a {@link Supplier} providing the default value
   */
  public IntSystemProperty(@NonNull String key, @NonNull Supplier<Integer> defaultValueSupplier) {
    super(key, defaultValueSupplier);
  }

  /**
   * Returns the value of the system property.
   *
   * @return the value of the system property or the default value if it is not set
   * @throws InvalidPropertyValueException if the default value would be returned, but it is null
   */
  public int get() {
    return super.getValueOrDefault();
  }

  @Override
  protected Integer parse(@NonNull String value) {
    try {
      return Integer.parseInt(value);
    } catch (Exception ex) {
      throw new InvalidPropertyValueException(
          "Cannot parse value of system property %s as int: %s".formatted(getKey(), value), ex);
    }
  }
}
