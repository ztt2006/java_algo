package com.itheima.algorithm.binarysearch;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static com.itheima.algorithm.binarysearch.BinarySearch.binarySearchAlternative;
import static com.itheima.algorithm.binarysearch.BinarySearch.binarySearchBasic;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBinarySearch {
    @Test
    @DisplayName("binarySearchBasic 找到")
    public void test1() {
        int[] a = {7, 13, 21, 30, 38, 44, 52, 53};
        assertEquals(0, binarySearchBasic(a, 7));
        assertEquals(1, binarySearchBasic(a, 13));
        assertEquals(2, binarySearchBasic(a, 21));
        assertEquals(3, binarySearchBasic(a, 30));
        assertEquals(4, binarySearchBasic(a, 38));
        assertEquals(5, binarySearchBasic(a, 44));
        assertEquals(6, binarySearchBasic(a, 52));
        assertEquals(7, binarySearchBasic(a, 53));
    }

    @Test
    @DisplayName("binarySearchBasic 没找到")
    public void test2() {
        int[] a = {7, 13, 21, 30, 38, 44, 52, 53};
        assertEquals(-1, binarySearchBasic(a, 0));
        assertEquals(-1, binarySearchBasic(a, 15));
        assertEquals(-1, binarySearchBasic(a, 60));
    }


    @Test
    @DisplayName("binarySearchAlternative 找到")
    public void test4() {
        int[] a = {7, 13, 21, 30, 38, 44, 52, 53};
        assertEquals(0, binarySearchAlternative(a, 7));
        assertEquals(1, binarySearchAlternative(a, 13));
        assertEquals(2, binarySearchAlternative(a, 21));
        assertEquals(3, binarySearchAlternative(a, 30));
        assertEquals(4, binarySearchAlternative(a, 38));
        assertEquals(5, binarySearchAlternative(a, 44));
        assertEquals(6, binarySearchAlternative(a, 52));
        assertEquals(7, binarySearchAlternative(a, 53));
    }

    @Test
    @DisplayName("binarySearchAlternative 没找到")

    public void test5() {
        int[] a = {7, 13, 21, 30, 38, 44, 52, 53};
        assertEquals(-1, binarySearchAlternative(a, 0));
        assertEquals(-1, binarySearchAlternative(a, 15));
        assertEquals(-1, binarySearchAlternative(a, 60));
    }
}
