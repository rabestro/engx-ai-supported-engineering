package org.epam.engx.task2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class SumOfPrimesBlackBoxC4Test {

    @DisplayName("Sum of primes up to n:")
    @ParameterizedTest(name = "Test case {index}: n = {0} -> sum = {1}")
    @CsvSource(delimiter = '|', textBlock = """
            -5 | 0
             0 | 0
             1 | 0
             2 | 2
             5 | 10
            10 | 17
            20 | 77
    """)
    void sumOfPrimesUpTo(int n, long expectedSum) {
        var sumOfPrimes = new SumOfPrimes();

        var result = sumOfPrimes.applyAsLong(n);

        assertThat(result)
                .withFailMessage("Expected sum of primes up to %d to be %d, but was %d", n, expectedSum, result)
                .isEqualTo(expectedSum);
    }
}