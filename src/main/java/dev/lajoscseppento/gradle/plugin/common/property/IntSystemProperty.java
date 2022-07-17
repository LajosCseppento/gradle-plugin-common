package dev.lajoscseppento.gradle.plugin.common.property;

import dev.lajoscseppento.gradle.plugin.common.property.impl.AbstractSystemProperty;
import java.util.function.Supplier;
import lombok.NonNull;

/** Represents an <code>int</code> system property. */
public class IntSystemProperty extends AbstractSystemProperty<Integer> {

  public IntSystemProperty(@NonNull String key, int defaultValue) {
    super(key, defaultValue);
  }

  public IntSystemProperty(@NonNull String key, @NonNull Supplier<Integer> defaultValueSupplier) {
    super(key, defaultValueSupplier);
  }

  public int get() {
    return super.getValueOrDefault();
  }

  @Override
  protected Integer parse(@NonNull String value) {
    try {
      return Integer.parseInt(value.trim());
    } catch (Exception ex) {
      throw new InvalidPropertyValueException(
          "Cannot parse value of system property " + getKey() + " as int: " + value, ex);
    }
  }
}
