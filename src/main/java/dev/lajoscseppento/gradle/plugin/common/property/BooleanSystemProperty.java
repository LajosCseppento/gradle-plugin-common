package dev.lajoscseppento.gradle.plugin.common.property;

import dev.lajoscseppento.gradle.plugin.common.property.impl.AbstractSystemProperty;
import java.util.function.Supplier;
import lombok.NonNull;

/**
 * Represents a boolean system property. Case-ignored <code>"true"</code> and <code>1</code> are
 * parsed as <code>true</code>, case-ignored <code>"false"</code> and <code>0</code> are parsed as
 * <code>false</code>. Other values are considered invalid.
 */
public class BooleanSystemProperty extends AbstractSystemProperty<Boolean> {
  public BooleanSystemProperty(@NonNull String key, boolean defaultValue) {
    super(key, defaultValue);
  }

  public BooleanSystemProperty(
      @NonNull String key, @NonNull Supplier<Boolean> defaultValueSupplier) {
    super(key, defaultValueSupplier);
  }

  public boolean get() {
    return super.getValueOrDefault();
  }

  @Override
  protected Boolean parse(@NonNull String value) {
    switch (value.trim().toLowerCase()) {
      case "true":
      case "1":
        return true;

      case "false":
      case "0":
        return false;

      default:
        throw new InvalidPropertyValueException(
            "Cannot parse value of system property " + getKey() + " as boolean: " + value);
    }
  }
}
