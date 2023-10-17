package dev.lajoscseppento.gradle.plugin.common.property;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junitpioneer.jupiter.SetSystemProperty;

class BooleanSystemPropertyTest {
  private BooleanSystemProperty property1;
  private BooleanSystemProperty property2;
  private BooleanSystemProperty property3;

  @BeforeEach
  void setUp() {
    property1 = new BooleanSystemProperty("property.boolean1", false);
    property2 = new BooleanSystemProperty("property.boolean2", () -> true);
    property3 = new BooleanSystemProperty("property.boolean3", () -> null);
  }

  @Test
  void testDefault() {
    assertThat(property1.get()).isFalse();
    assertThat(property2.get()).isTrue();
  }

  @SetSystemProperty(key = "property.boolean1", value = " tRUE ")
  @SetSystemProperty(key = "property.boolean2", value = " 1 ")
  @Test
  void testTrue() {
    assertThat(property1.get()).isTrue();
    assertThat(property2.get()).isTrue();
  }

  @SetSystemProperty(key = "property.boolean1", value = " fALSE ")
  @SetSystemProperty(key = "property.boolean2", value = " 0 ")
  @Test
  void testFalse() {
    assertThat(property1.get()).isFalse();
    assertThat(property2.get()).isFalse();
  }

  @SetSystemProperty(key = "property.boolean1", value = "abc")
  @Test
  void testInvalid() {
    assertThatThrownBy(() -> property1.get())
        .isExactlyInstanceOf(InvalidPropertyValueException.class)
        .hasMessage("Cannot parse value of system property property.boolean1 as boolean: abc")
        .hasNoCause();
  }

  @Test
  void testNullDefaultValue() {
    assertThatThrownBy(() -> property3.get())
        .isExactlyInstanceOf(InvalidPropertyValueException.class)
        .hasMessage(
            "System property property.boolean3 has a null value, but a primitive type was requested (BooleanSystemProperty)")
        .hasNoCause();
  }
}
