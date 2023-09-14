package com.epam.engx.task2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.function.ToIntFunction;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

@DisplayName("ArrayMaxFinder test:")
class ArrayMaxFinderBlackBoxC4Test {

  private final ToIntFunction<int[]> arrayMaxFinder = new ArrayMaxFinder();

  static Stream<Arguments> testCases() {
    return Stream.of(
        Arguments.of("Array with one element", new int[]{5}, 5),
        Arguments.of("Array with two elements, ascending order", new int[]{3, 7}, 7),
        Arguments.of("Array with two elements, descending order", new int[]{7, 3}, 7),
        Arguments.of("Array with multiple elements, unsorted", new int[]{4, 2, 9, 1, 5}, 9),
        Arguments.of("Array with multiple elements, ascending", new int[]{1, 2, 3, 4, 5}, 5),
        Arguments.of("Array with multiple elements, descending", new int[]{5, 4, 3, 2, 1}, 5),
        Arguments.of("Array with negative elements", new int[]{-3, -7, -1, -5}, -1),
        Arguments.of("Mixed positive and negative elements", new int[]{3, -7, 1, 5, -2}, 5)
    );
  }

  @DisplayName("Test cases:")
  @ParameterizedTest(name = "[{index}] {0}: {1} -> {2}")
  @MethodSource("testCases")
  void testArrayMaxFinder(String description, int[] input, int expectedOutput) {
    assertThat(arrayMaxFinder.applyAsInt(input))
        .as("Max element in the array %s should be %d", input, expectedOutput)
        .isEqualTo(expectedOutput);
  }

  @DisplayName("Empty array test:")
  @ParameterizedTest(name = "[{index}] Empty array")
  @EmptySource
  void testArrayMaxFinderWithEmptyArray(int[] input) {
    assertThatIllegalArgumentException()
        .as("Finding max element in an empty array should throw IllegalArgumentException")
        .isThrownBy(() -> arrayMaxFinder.applyAsInt(input));
  }

  @DisplayName("Null input test:")
  @ParameterizedTest(name = "[{index}] Null input")
  @NullSource
  void testArrayMaxFinderWithNullInput(int[] input) {
    assertThatIllegalArgumentException()
        .as("Finding max element in a null array should throw IllegalArgumentException")
        .isThrownBy(() -> arrayMaxFinder.applyAsInt(input));
  }
}