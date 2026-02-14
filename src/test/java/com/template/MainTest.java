package com.template;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    
    @Test
    @DisplayName("Prueba de Gnome Sort")
    public void testGnomeSort() {
        Integer[] arr = {5, 2, 9, 1, 5, 6};
        Integer[] expected = {1, 2, 5, 5, 6, 9};
        Sorts.gnomeSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    @DisplayName("Prueba de Merge Sort")
    public void testMergeSort() {
        Integer[] arr = {12, 11, 13, 5, 6, 7};
        Integer[] expected = {5, 6, 7, 11, 12, 13};
        Sorts.mergeSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    @DisplayName("Prueba de Quick Sort")
    public void testQuickSort() {
        Integer[] arr = {10, 7, 8, 9, 1, 5};
        Integer[] expected = {1, 5, 7, 8, 9, 10};
        Sorts.quickSort(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr);
    }

    @Test
    @DisplayName("Prueba de Radix Sort")
    public void testRadixSort() {
        Integer[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        Integer[] expected = {2, 24, 45, 66, 75, 90, 170, 802};
        Sorts.radixSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    @DisplayName("Prueba de Bubble Sort")
    public void testBubbleSort() {
        Integer[] arr = {64, 34, 25, 12, 22, 11, 90};
        Integer[] expected = {11, 12, 22, 25, 34, 64, 90};
        Sorts.bubbleSort(arr);
        assertArrayEquals(expected, arr);
    }
}