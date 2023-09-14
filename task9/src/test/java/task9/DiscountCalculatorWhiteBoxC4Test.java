package task9;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.within;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("DiscountCalculator WhiteBoxC4Test")
class DiscountCalculatorWhiteBoxC4Test {

  static Stream<Arguments> validInputTestCases() {
    return Stream.of(
        Arguments.of("No discount, no tax", 100.0, 0.0, 0.0, 100.0),
        Arguments.of("Full discount, no tax", 100.0, 100.0, 0.0, 0.0),
        Arguments.of("Partial discount, no tax", 100.0, 20.0, 0.0, 80.0),
        Arguments.of("No discount, with tax", 100.0, 0.0, 10.0, 110.0),
        Arguments.of("Full discount, with tax", 100.0, 100.0, 10.0, 0.0),
        Arguments.of("Partial discount, with tax", 100.0, 20.0, 10.0, 88.0),
        Arguments.of("Minimum positive original price", Double.MIN_VALUE, 20.0, 10.0,
            Double.MIN_VALUE * 0.8 * 1.1),
        Arguments.of("Positive original price", 50.0, 20.0, 10.0, 44.0)
    );
  }

  static Stream<Arguments> invalidInputTestCases() {
    return Stream.of(
        Arguments.of("NaN original price", Double.NaN, 20.0, 10.0),
        Arguments.of("NaN discount percentage", 100.0, Double.NaN, 10.0),
        Arguments.of("NaN tax rate", 100.0, 20.0, Double.NaN),
        Arguments.of("Negative discount percentage", 100.0, -1.0, 10.0),
        Arguments.of("Discount percentage greater than 100", 100.0, 101.0, 10.0),
        Arguments.of("Negative tax rate", 100.0, 20.0, -1.0),
        Arguments.of("Tax rate greater than 100", 100.0, 20.0, 101.0),
        Arguments.of("Minimum negative original price", Double.MIN_VALUE * -1, 20.0, 10.0),
        Arguments.of("Negative original price", -50.0, 20.0, 10.0)
    );
  }

  @DisplayName("Valid input test cases:")
  @ParameterizedTest(name = "[{index}] {0}")
  @MethodSource("validInputTestCases")
  void validInputTestCases(String description, double originalPrice, double discountPercentage,
      double taxRate, double expectedOutput) {
    double result = DiscountCalculator.calculateDiscountedPriceWithTax(originalPrice,
        discountPercentage, taxRate);
    assertThat(result).isCloseTo(expectedOutput, within(1e-8));
  }

  @DisplayName("Invalid input test cases:")
  @ParameterizedTest(name = "[{index}] {0}")
  @MethodSource("invalidInputTestCases")
  void invalidInputTestCases(String description, double originalPrice, double discountPercentage,
      double taxRate) {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> DiscountCalculator.calculateDiscountedPriceWithTax(originalPrice,
            discountPercentage, taxRate));
  }
}