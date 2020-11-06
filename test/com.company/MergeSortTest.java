package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {
    MergeSort ms = new MergeSort();
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
        assertArrayEquals(new int[]{11,23,36,42,58,65,74,87,94,99,101}, ms.sort(A));
    }

    @Test
    void sortIfHavingSameElements() {
        assertArrayEquals(new int[]{1,3,3,5,6,7,8,9,10,12,15}, ms.sort(ASame));
    }

    @Test
    void sortIfDescending() {
        assertArrayEquals(new int[]{0,1,2,3,4,5,6,7}, ms.sort(ADesc));
    }

    @Test
    void sortIfAscending() {
        assertArrayEquals(new int[]{0,1,2,3,4,5,6,7}, ms.sort(AAsc));
    }

    @Test
    void straightMergeSort() {
    }

    @Test
    void mergeSections() {
    }

    @Test
    void mergeSectionBySection() {
    }

    @Test
    void determineSection() {
    }

    @Test
    void mergeSectionsInNatural() {
    }
}