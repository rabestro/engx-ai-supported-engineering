package com.epam.engx.task2;

import java.util.Arrays;
import java.util.function.ToIntFunction;

public class ArrayMaxFinder implements ToIntFunction<int[]> {

    /**
     * Finds the maximum element in the input array of integers.
     *
     * @param arr The input array of integers.
     * @return The maximum integer value in the array.
     * @throws IllegalArgumentException if the input array is null or empty.
     */
    @Override
    public int applyAsInt(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Input array must not be null or empty");
        }

        return Arrays.stream(arr).max().getAsInt();
    }
}