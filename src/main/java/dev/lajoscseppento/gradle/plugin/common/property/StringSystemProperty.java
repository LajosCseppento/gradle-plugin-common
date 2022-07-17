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
  public StringSystemProperty(@NonNull String key, @Nullable String defaultValue) {
    super(key, defaultValue, Function.identity());
  }

  public StringSystemProperty(@NonNull String key, @NonNull Supplier<String> defaultValueSupplier) {
    super(key, defaultValueSupplier, Function.identity());
  }
}
