package dev.lajoscseppento.gradle.plugin.common.property;

import java.util.function.Function;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import lombok.NonNull;

/** Represents a string system property. */
public class StringSystemProperty extends ObjectSystemProperty<String> {
  private static final Function<String, String> PARSER = String::trim;

  public StringSystemProperty(@NonNull String key, @Nullable String defaultValue) {
    super(key, defaultValue, PARSER);
  }

  public StringSystemProperty(@NonNull String key, @NonNull Supplier<String> defaultValueSupplier) {
    super(key, defaultValueSupplier, PARSER);
  }
}
