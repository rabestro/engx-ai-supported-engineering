package org.epam.engx.task2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ArrayMaxFinderDiffblueTest {

  /**
   * Method under test: {@link ArrayMaxFinder#applyAsInt(int[])}
   */
  @Test
  void testApplyAsInt() {
    ArrayMaxFinder arrayMaxFinder = new ArrayMaxFinder();
    int[] arr = new int[]{1, -1, 1, -1};
    int actualApplyAsIntResult = arrayMaxFinder.applyAsInt(arr);
    assertEquals(1, actualApplyAsIntResult);
  }

  /**
   * Method under test: {@link ArrayMaxFinder#applyAsInt(int[])}
   */
  @Test
  void testApplyAsInt2() {
    ArrayMaxFinder arrayMaxFinder = new ArrayMaxFinder();
    int[] arr = null;
    assertThrows(IllegalArgumentException.class, () -> arrayMaxFinder.applyAsInt(arr));
  }

  /**
   * Method under test: {@link ArrayMaxFinder#applyAsInt(int[])}
   */
  @Test
  void testApplyAsInt3() {
    ArrayMaxFinder arrayMaxFinder = new ArrayMaxFinder();
    int[] arr = new int[]{};
    assertThrows(IllegalArgumentException.class, () -> arrayMaxFinder.applyAsInt(arr));
  }
}