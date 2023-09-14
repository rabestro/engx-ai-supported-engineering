package com.epam.engx.task2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class TitleCaseConverterDiffblueTest {

  /**
   * Method under test: {@link TitleCaseConverter#apply(String)}
   */
  @Test
  void testApply() {
    TitleCaseConverter titleCaseConverter = new TitleCaseConverter();
    String input = "Input";
    String actualApplyResult = titleCaseConverter.apply(input);
    assertEquals("Input", actualApplyResult);
  }

  /**
   * Method under test: {@link TitleCaseConverter#apply(String)}
   */
  @Test
  void testApply2() {
    TitleCaseConverter titleCaseConverter = new TitleCaseConverter();
    String input = null;
    String actualApplyResult = titleCaseConverter.apply(input);
    assertNull(actualApplyResult);
  }
}