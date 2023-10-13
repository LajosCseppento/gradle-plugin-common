package dev.lajoscseppento.gradle.plugin.common.property.impl;

import dev.lajoscseppento.gradle.plugin.common.property.InvalidPropertyValueException;
import java.util.function.Supplier;
import lombok.NonNull;

/**
 * Base class for system properties with a primitive type.
 *
 * @param <T> value type
 */
public abstract class PrimitiveSystemProperty<T> extends AbstractSystemProperty<T> {
  /**
   * Initialises the abstract class.
   *
   * @param key the system property key
   * @param defaultValue the default value
   */
  protected PrimitiveSystemProperty(@NonNull String key, T defaultValue) {
    super(key, defaultValue);
  }

  /**
   * Initialises the abstract class.
   *
   * @param key the property key
   * @param defaultValueSupplier a {@link Supplier} providing the default value
   */
  protected PrimitiveSystemProperty(
      @NonNull String key, @NonNull Supplier<T> defaultValueSupplier) {
    super(key, defaultValueSupplier);
  }

  @Override
  protected T getValueOrDefault() {
    T value = super.getValueOrDefault();
    if (value == null) {
      throw new InvalidPropertyValueException(
          "System property %s has a null value, but a primitive type was requested (%s)"
              .formatted(getKey(), getClass().getSimpleName()));
    }
    return value;
  }
}
