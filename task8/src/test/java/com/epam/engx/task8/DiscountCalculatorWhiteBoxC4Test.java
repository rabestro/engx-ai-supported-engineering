package com.epam.engx.task8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

@DisplayName("DiscountCalculator WhiteBoxC4Test")
class DiscountCalculatorWhiteBoxC4Test {

  static Stream<Arguments> validInputTestCases() {
    return Stream.of(
        Arguments.of("No discount (0%)", 100.0, 0.0, 100.0),
        Arguments.of("Full discount (100%)", 100.0, 100.0, 0.0),
        Arguments.of("Partial discount (20%)", 100.0, 20.0, 80.0),
        Arguments.of("Minimum discount (0.01%)", 100.0, 0.01, 99.99),
        Arguments.of("Maximum discount (99.99%)", 100.0, 99.99, 0.01),
        Arguments.of("Original price is zero", 0.0, 20.0, 0.0),
        Arguments.of("Negative original price", -100.0, 20.0, -80.0),
        Arguments.of("Minimum positive original price", Double.MIN_VALUE, 20.0,
            Double.MIN_VALUE * 0.8),
        Arguments.of("Maximum positive original price", Double.MAX_VALUE, 20.0,
            Double.MAX_VALUE * 0.8)
    );
  }

  static Stream<Arguments> invalidInputTestCases() {
    return Stream.of(
        Arguments.of("NaN original price", Double.NaN, 20.0),
        Arguments.of("NaN discount percentage", 100.0, Double.NaN),
        Arguments.of("Negative discount percentage", 100.0, -1.0),
        Arguments.of("Discount percentage greater than 100", 100.0, 101.0)
    );
  }

  @DisplayName("Valid input test cases:")
  @ParameterizedTest(name = "[{index}] {0}")
  @MethodSource("validInputTestCases")
  void validInputTestCases(String description, double originalPrice, double discountPercentage,
      double expectedOutput) {
    double result = DiscountCalculator.calculateDiscountedPrice(originalPrice, discountPercentage);
    assertThat(result).isCloseTo(expectedOutput, within(1e-10));
  }

  @DisplayName("Invalid input test cases:")
  @ParameterizedTest(name = "[{index}] {0}")
  @MethodSource("invalidInputTestCases")
  void invalidInputTestCases(String description, double originalPrice, double discountPercentage) {
    assertThatIllegalArgumentException()
        .isThrownBy(
            () -> DiscountCalculator.calculateDiscountedPrice(originalPrice, discountPercentage));
  }
}