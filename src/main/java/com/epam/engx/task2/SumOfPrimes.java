package com.epam.engx.task2;

import java.util.function.IntToLongFunction;

/**
 * A class that calculates the sum of all prime numbers up to a given integer 'n'.
 * Implements the IntToLongFunction functional interface.
 */
public class SumOfPrimes implements IntToLongFunction {

    /**
     * Calculates the sum of all prime numbers up to the given integer 'n'.
     *
     * @param n The upper limit for prime numbers to be included in the sum.
     * @return The sum of all prime numbers up to 'n'.
     */
    @Override
    public long applyAsLong(int n) {
        if (n < 2) {
            return 0;
        }

        long sum = 2;
        for (int i = 3; i <= n; i += 2) {
            if (isPrime(i)) {
                sum += i;
            }
        }
        return sum;
    }

    /**
     * Checks if a given number is prime.
     *
     * @param number The number to check for primality.
     * @return true if the number is prime, false otherwise.
     */
    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number == 2 || number == 3) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}