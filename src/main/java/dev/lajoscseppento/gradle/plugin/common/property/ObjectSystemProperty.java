package dev.lajoscseppento.gradle.plugin.common.property;

import dev.lajoscseppento.gradle.plugin.common.property.impl.AbstractSystemProperty;
import java.util.function.Function;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import lombok.NonNull;

/**
 * Represents an object system property.
 *
 * <p>During parsing string values are trimmed.
 *
 * @param <T> value type
 */
public class ObjectSystemProperty<T> extends AbstractSystemProperty<T> {

  private final Function<String, T> parser;

  public ObjectSystemProperty(
      @NonNull String key, @Nullable T defaultValue, @NonNull Function<String, T> parser) {
    super(key, defaultValue);
    this.parser = parser;
  }

  public ObjectSystemProperty(
      @NonNull String key,
      @NonNull Supplier<T> defaultValueSupplier,
      @NonNull Function<String, T> parser) {
    super(key, defaultValueSupplier);
    this.parser = parser;
  }

  /**
   * Returns the value of the system property.
   *
   * @return the value of the system property
   * @throws InvalidPropertyValueException if the value is invalid
   */
  @Nullable
  public final T get() {
    return super.getValueOrDefault();
  }

  @Override
  protected final T parse(@NonNull String value) {
    return parser.apply(value);
  }
}
