package com.company;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class testSort {
    Sort ins = new Sort();
    int[] A = new int[]{1,5,3,9,2,10,12,6,7,8,15};
    int[] result = new int[A.length];
    int[] result1 = new int[A.length];
    int[] A1 = new int[]{1,3,5,9,2,6,7,8,10,12,15};
    int[] A2 = new int[]{12,10,15,6,2,7,8,1,3,9,5};
    int[] result2 = new int[A.length];
    
    @Test
    public void testMerging() {
        assertArrayEquals(ins.merging(new int[]{}, new int[]{}), new int[]{});
        assertArrayEquals(ins.merging(new int[]{1,3,5,9}, new int[]{2,6,7,8,10,12,15}), new int[]{1,2,3,5,6,7,8,9,10,12,15});
        assertArrayEquals(ins.merging(new int[]{}, new int[]{2,6,7,8,10,12,15}), new int[]{2,6,7,8,10,12,15});
        assertArrayEquals(ins.merging(new int[]{1,3,5,9}, new int[]{}), new int[]{1,3,5,9});
        assertArrayEquals(ins.merging(new int[]{1,3,5,9}, new int[]{3}), new int[]{1,3,3,5,9});
    }

    @Test
    public void testMergingSection() {
        assertArrayEquals(ins.mergingSection(A, 2, 0 , A, 2, 2, result1, 0), new int[]{1,3,5,9,0,0,0,0,0,0,0});
        assertArrayEquals(ins.mergingSection(A, 3, 4 , A, 4, 7, result2, 4), new int[]{0,0,0,0,2,6,7,8,10,12,15});
        assertArrayEquals(ins.mergingSection(A1, 4, 0 , A1, 7, 4, result, 0), new int[]{1,2,3,5,6,7,8,9,10,12,15});
    }

    @Test
    public void testMPass() {
        assertArrayEquals(ins.MPass(A2, 1, result), new int[]{3,6,7,8,1,3,5,9,10,12,15});
        assertArrayEquals(ins.MPass(result, 2, result1), new int[]{3,6,7,8,1,3,5,9,10,12,15});
    }

    @Test
    public void testStraightMerge() {
        assertArrayEquals(ins.StraightMergeSort(A2), new int[]{1,2,3,5,6,7,8,9,10,12,15});
    }
}