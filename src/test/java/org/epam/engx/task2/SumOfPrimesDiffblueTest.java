package org.epam.engx.task2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SumOfPrimesDiffblueTest {

  /**
   * Method under test: {@link SumOfPrimes#applyAsLong(int)}
   */
  @Test
  void testApplyAsLong() {
    SumOfPrimes sumOfPrimes = new SumOfPrimes();
    int n = 1;
    long actualApplyAsLongResult = sumOfPrimes.applyAsLong(n);
    assertEquals(0L, actualApplyAsLongResult);
  }

  /**
   * Method under test: {@link SumOfPrimes#applyAsLong(int)}
   */
  @Test
  void testApplyAsLong2() {
    SumOfPrimes sumOfPrimes = new SumOfPrimes();
    int n = 2;
    long actualApplyAsLongResult = sumOfPrimes.applyAsLong(n);
    assertEquals(2L, actualApplyAsLongResult);
  }

  /**
   * Method under test: {@link SumOfPrimes#applyAsLong(int)}
   */
  @Test
  void testApplyAsLong3() {
    SumOfPrimes sumOfPrimes = new SumOfPrimes();
    int n = 3;
    long actualApplyAsLongResult = sumOfPrimes.applyAsLong(n);
    assertEquals(5L, actualApplyAsLongResult);
  }

  /**
   * Method under test: {@link SumOfPrimes#applyAsLong(int)}
   */
  @Test
  void testApplyAsLong4() {
    SumOfPrimes sumOfPrimes = new SumOfPrimes();
    int n = 5;
    long actualApplyAsLongResult = sumOfPrimes.applyAsLong(n);
    assertEquals(10L, actualApplyAsLongResult);
  }

  /**
   * Method under test: {@link SumOfPrimes#applyAsLong(int)}
   */
  @Test
  void testApplyAsLong5() {
    SumOfPrimes sumOfPrimes = new SumOfPrimes();
    int n = 9;
    long actualApplyAsLongResult = sumOfPrimes.applyAsLong(n);
    assertEquals(17L, actualApplyAsLongResult);
  }

  /**
   * Method under test: {@link SumOfPrimes#applyAsLong(int)}
   */
  @Test
  void testApplyAsLong6() {
    SumOfPrimes sumOfPrimes = new SumOfPrimes();
    int n = 11;
    long actualApplyAsLongResult = sumOfPrimes.applyAsLong(n);
    assertEquals(28L, actualApplyAsLongResult);
  }
}