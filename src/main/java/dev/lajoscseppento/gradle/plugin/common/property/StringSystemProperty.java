package dev.lajoscseppento.gradle.plugin.common.property;

import java.util.function.Function;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import lombok.NonNull;

/**
 * Represents a string system property.
 *
 * <p>During parsing string values are trimmed.
 */
public class StringSystemProperty extends ObjectSystemProperty<String> {
  /**
   * Creates a string system property.
   *
   * @param key the property key
   * @param defaultValue a {@code Supplier<String>} providing the default value
   */
  public StringSystemProperty(@NonNull String key, @Nullable String defaultValue) {
    super(key, defaultValue, Function.identity());
  }

  /**
   * Creates a string system property.
   *
   * @param key the property key
   * @param defaultValueSupplier a {@code Supplier<String>} providing the default value
   */
  public StringSystemProperty(@NonNull String key, @NonNull Supplier<String> defaultValueSupplier) {
    super(key, defaultValueSupplier, Function.identity());
  }
}
