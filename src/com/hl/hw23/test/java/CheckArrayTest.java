package com.hl.hw23.test.java;

import com.hl.hw23.main.java.CheckArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckArrayTest {
    @Test
    public void shouldReturnNewArrayWhenFourPresentSingle() {
        int[] array = {2, 1, 5, 7, 9, 4, 3, 5};
        int[] expected = {3, 5};
        Assertions.assertArrayEquals(expected, CheckArray.arrayAfterFour(array));
    }

    @Test
    public void shouldReturnNewArrayWhenFourPresentPlural() {
        int[] array = {4, 5, 1, 5, 7, 9, 4, 3, 5, 4, 2, 1, 6, 7};
        int[] expected = {2, 1, 6, 7};
        Assertions.assertArrayEquals(expected, CheckArray.arrayAfterFour(array));
    }

    @Test
    public void shouldReturnExceptionWhenFourMissing() {
        int[] array = {5, 1, 3, 7, 8};
        Assertions.assertThrowsExactly(RuntimeException.class, () -> CheckArray.arrayAfterFour(array));
    }

    @Test
    public void shouldReturnFalseWhenFourMissing() {
        int[] array = {1, 1, 1, 1, 1, 1, 1};
        Assertions.assertFalse(CheckArray.onlyFourAndOne(array));
    }

    @Test
    public void shouldReturnFalseWhenOneMissing() {
        int[] array = {4, 4, 4, 4, 4, 4, 4};
        Assertions.assertFalse(CheckArray.onlyFourAndOne(array));
    }

    @Test
    public void shouldReturnTrueWhenFourAndOnePresent() {
        int[] array = {1, 4, 4, 4, 1, 1, 4, 1, 4};
        Assertions.assertTrue(CheckArray.onlyFourAndOne(array));
    }
}
