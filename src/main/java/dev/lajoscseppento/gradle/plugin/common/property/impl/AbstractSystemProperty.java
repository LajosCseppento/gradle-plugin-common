package dev.lajoscseppento.gradle.plugin.common.property.impl;

import dev.lajoscseppento.gradle.plugin.common.impl.Utils;
import dev.lajoscseppento.gradle.plugin.common.property.InvalidPropertyValueException;
import java.util.function.Supplier;
import lombok.Getter;
import lombok.NonNull;

/**
 * Base class for system properties.
 *
 * <p>During parsing string values are trimmed.
 *
 * @param <T> value type
 */
public abstract class AbstractSystemProperty<T> {
  @Getter private final String key;
  private final T defaultValue;
  private final Supplier<T> defaultValueSupplier;

  protected AbstractSystemProperty(@NonNull String key, T defaultValue) {
    this.key = key;
    this.defaultValue = defaultValue;
    this.defaultValueSupplier = null;
  }

  protected AbstractSystemProperty(@NonNull String key, @NonNull Supplier<T> defaultValueSupplier) {
    this.key = key;
    this.defaultValue = null;
    this.defaultValueSupplier = defaultValueSupplier;
  }

  protected final T getValueOrDefault() {
    String value = Utils.trimToNull(System.getProperty(key));

    if (value == null) {
      return defaultValueSupplier == null ? defaultValue : defaultValueSupplier.get();
    } else {
      return parse(value);
    }
  }

  /**
   * Parses the value of the system property.
   *
   * @param value the value (trimmed)
   * @return the parsed value
   * @throws InvalidPropertyValueException if the value is invalid
   */
  protected abstract T parse(@NonNull String value);
}
