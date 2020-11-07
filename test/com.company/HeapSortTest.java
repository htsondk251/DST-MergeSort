package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeapSortTest {
    HeapSort hs = new HeapSort();
    int[] A, AAsc, ADesc, ASame;
    int[] result;

    @BeforeEach
    void setUp() {
        A= new int[]{42, 23, 74, 11, 65, 58, 94, 36, 99, 87, 101};
        ASame = new int[]{1,5,3,9,3,10,12,6,7,8,15};
        result = A.clone();

        AAsc = new int[]{0,1,2,3,4,5,6,7};
        ADesc = new int[]{7,6,5,4,3,2,1,0};
    }

    @Test
    void sortIfNormal() {
        assertArrayEquals(new int[]{11,23,36,42,58,65,74,87,94,99,101}, hs.sort1(A));
    }

    @Test
    void sortIfHavingSameElements() {
        assertArrayEquals(new int[]{1,3,3,5,6,7,8,9,10,12,15}, hs.sort1(ASame));
    }

    @Test
    void sortIfDescending() {
        assertArrayEquals(new int[]{0,1,2,3,4,5,6,7}, hs.sort1(ADesc));
    }

    @Test
    void sortIfAscending() {
        assertArrayEquals(new int[]{0,1,2,3,4,5,6,7}, hs.sort1(AAsc));
    }

    @Test
    void max_heapify() {
        assertArrayEquals(new int[]{42,23,74,11,101,58,94,36,99,87,65}, hs.max_heapify(A, A.length, 4));
        assertArrayEquals(new int[]{1,5,3,9,15,10,12,6,7,8,3}, hs.max_heapify(ASame, ASame.length, 4));
        assertArrayEquals(new int[]{0,4,2,3,1,5,6,7}, hs.max_heapify(AAsc, AAsc.length,1));
    }

    @Test
    void build_max_heap() {
        assertArrayEquals(new int[]{101,99,94,42,87,58,74,36,11,23,65}, hs.build_max_heap(A));
        assertArrayEquals(new int[]{15,9,12,7,8,10,3,6,1,5,3}, hs.build_max_heap(ASame));
        assertArrayEquals(new int[]{7,4,6,3,0,5,2,1}, hs.build_max_heap(AAsc));

    }
}