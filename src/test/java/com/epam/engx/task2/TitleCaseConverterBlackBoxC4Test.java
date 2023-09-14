package com.epam.engx.task2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.function.UnaryOperator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;

@DisplayName("TitleCaseConverter test:")
class TitleCaseConverterBlackBoxC4Test {

  private final UnaryOperator<String> titleCaseConverter = new TitleCaseConverter();

  @DisplayName("Test cases:")
  @ParameterizedTest(name = "[{index}] {0}: {1} -> {2}")
  @CsvSource(delimiter = '|', emptyValue = "''", textBlock = """
      Empty string                    | ''               | ''
      Single word, all lowercase      | hello            | Hello
      Single word, all uppercase      | HELLO            | Hello
      Single word, mixed case         | hELlO            | Hello
      Multiple words, all lowercase   | hello world      | Hello World
      Multiple words, all uppercase   | HELLO WORLD      | Hello World
      Multiple words, mixed case      | hELlO wORLd      | Hello World
      Multiple words with extra spaces|   hello   world  |   Hello   World  
      """)
  void testTitleCaseConverter(String description, String input, String expectedOutput) {
    assertThat(titleCaseConverter.apply(input))
        .as("Title case conversion for '%s' should be '%s'", input, expectedOutput)
        .isEqualTo(expectedOutput);
  }

  @DisplayName("Null input test:")
  @ParameterizedTest(name = "[{index}] Null input")
  @NullSource
  void testTitleCaseConverterWithNullInput(String input) {
    assertThat(titleCaseConverter.apply(input))
        .as("Title case conversion for null input should return null")
        .isNull();
  }
}