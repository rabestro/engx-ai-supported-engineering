package org.epam.engx.task1;

import java.util.Locale;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

public class TextPreprocessing implements UnaryOperator<String> {

  private static final Pattern NON_ALPHABETIC_PATTERN =
      Pattern.compile("[^\\p{L}\\p{Z}]", Pattern.UNICODE_CHARACTER_CLASS);

  @Override
  public String apply(String inputText) {
    if (inputText == null) {
      return null;
    }
    var lowercaseText = inputText.toLowerCase(Locale.ROOT);
    return NON_ALPHABETIC_PATTERN.matcher(lowercaseText).replaceAll("");
  }
}