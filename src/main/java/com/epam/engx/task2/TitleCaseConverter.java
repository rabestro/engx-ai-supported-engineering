package com.epam.engx.task2;

import java.util.function.UnaryOperator;

/**
 * A class that implements the UnaryOperator<String> interface to convert a given string to title case,
 * where the first letter of each word is capitalized, and the rest of the letters are in lowercase.
 */
public class TitleCaseConverter implements UnaryOperator<String> {

    /**
     * Converts the input string to title case.
     *
     * @param input The input string to be converted.
     * @return The title-cased string, or null if the input is null.
     */
    @Override
    public String apply(String input) {
        if (input == null) {
            return null;
        }

        var titleCaseBuilder = new StringBuilder();
        var nextCharTitleCase = true;

        for (char c : input.toCharArray()) {
            if (Character.isWhitespace(c)) {
                nextCharTitleCase = true;
            } else if (nextCharTitleCase) {
                c = Character.toTitleCase(c);
                nextCharTitleCase = false;
            } else {
                c = Character.toLowerCase(c);
            }
            titleCaseBuilder.append(c);
        }

        return titleCaseBuilder.toString();
    }
}