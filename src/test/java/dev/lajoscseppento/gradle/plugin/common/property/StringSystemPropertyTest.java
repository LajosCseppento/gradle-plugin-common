package dev.lajoscseppento.gradle.plugin.common.property;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junitpioneer.jupiter.SetSystemProperty;

class StringSystemPropertyTest {
  private StringSystemProperty property1;
  private StringSystemProperty property2;

  @BeforeEach
  void setUp() {
    property1 = new StringSystemProperty("property.string1", "banana");
    property2 = new StringSystemProperty("property.string2", () -> null);
  }

  @Test
  void testDefault() {
    assertThat(property1.get()).isEqualTo("banana");
    assertThat(property2.get()).isNull();
  }

  @SetSystemProperty(key = "property.string1", value = " null ")
  @SetSystemProperty(key = "property.string2", value = " 123 ")
  @Test
  void test() {
    assertThat(property1.get()).isEqualTo("null");
    assertThat(property2.get()).isEqualTo("123");
  }
}
