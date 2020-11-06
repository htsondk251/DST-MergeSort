package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {
    QuickSort qs = new QuickSort();
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
        assertArrayEquals(new int[]{11,23,36,42,58,65,74,87,94,99,101}, qs.sort(A));
    }

    @Test
    void sortIfHavingSameElements() {
//        assertArrayEquals(new int[]{1,3,3,5,6,7,8,9,10,12,15}, qs.sort(ASame));
        assertArrayEquals(new int[]{3,3,5}, qs.sort(new int[]{3,3,5}));
    }

    @Test
    void sortIfDescending() {
        assertArrayEquals(new int[]{0,1,2,3,4,5,6,7}, qs.sort(ADesc));
    }

    @Test
    void sortIfAscending() {
        assertArrayEquals(new int[]{0,1,2,3,4,5,6,7}, qs.sort(AAsc));
    }

    @Test
    void quickSort() {
    }

    @Test
    void partBy2Pointers() {
        assertEquals(3, qs.partBy2Pointers(A, 0, A.length-1));
        assertEquals(0, qs.partBy2Pointers(new int[]{11,23,36}, 0, 2));
        assertEquals(2, qs.partBy2Pointers(new int[]{36,23,11}, 0, 2));
    }

    @Test
    void part() {
        assertEquals(3, qs.part(A, 0, A.length-1));
        assertEquals(0, qs.part(new int[]{11,23,36}, 0, 2));
        assertEquals(2, qs.part(new int[]{36,23,11}, 0, 2));
    }
}