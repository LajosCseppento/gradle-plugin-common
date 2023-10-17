package dev.lajoscseppento.gradle.plugin.common.property;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junitpioneer.jupiter.SetSystemProperty;

class IntSystemPropertyTest {
  private IntSystemProperty property1;
  private IntSystemProperty property2;
  private IntSystemProperty property3;

  @BeforeEach
  void setUp() {
    property1 = new IntSystemProperty("property.int1", 0);
    property2 = new IntSystemProperty("property.int2", () -> 1);
    property3 = new IntSystemProperty("property.int3", () -> null);
  }

  @Test
  void testDefault() {
    assertThat(property1.get()).isZero();
    assertThat(property2.get()).isOne();
  }

  @SetSystemProperty(key = "property.int1", value = " 2 ")
  @SetSystemProperty(key = "property.int2", value = " -2 ")
  @Test
  void test() {
    assertThat(property1.get()).isEqualTo(2);
    assertThat(property2.get()).isEqualTo(-2);
  }

  @SetSystemProperty(key = "property.int1", value = "abc")
  @Test
  void testInvalid() {
    assertThatThrownBy(() -> property1.get())
        .isExactlyInstanceOf(InvalidPropertyValueException.class)
        .hasMessage("Cannot parse value of system property property.int1 as int: abc")
        .cause()
        .isExactlyInstanceOf(NumberFormatException.class)
        .hasMessage("For input string: \"abc\"")
        .hasNoCause();
  }

  @Test
  void testNullDefaultValue() {
    assertThatThrownBy(() -> property3.get())
        .isExactlyInstanceOf(InvalidPropertyValueException.class)
        .hasMessage(
            "System property property.int3 has a null value, but a primitive type was requested (IntSystemProperty)")
        .hasNoCause();
  }
}
