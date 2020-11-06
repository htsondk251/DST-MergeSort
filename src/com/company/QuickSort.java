package com.company;

import java.util.Arrays;

public class QuickSort {
    //todo: swap method in java

    public int[] sort(int[] a) {
        return quickSort(a, 0, a.length-1);
    }
    /**
     * Quicksort: sort array a,
     * @param LB - lower bound
     * @param UB - upper bound
     */
    public int[] quickSort(int[] a, int LB, int UB) {
        if (LB <UB) {
            int j = part(a, LB, UB);
//            int j = partBy2Pointers(a, LB, UB);
            quickSort(a, LB, j-1);
            quickSort(a, j+1, UB);
        }
        return a;
    }
    //done: use 2-pointer technique in quick sort
    public int partBy2Pointers(int[]a, int LB, int UB) {
        int i = LB + 1, temp;
        for (int j = LB+1; j <= UB; j++) {
            if (a[j] <= a[LB]) {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;

//                a[i] = a[j] - a[i];
//                a[j] = a[j] + a[i];
//                a[i] = a[j] - a[i];
                i++;
            }
        }
        i = i-1;
        temp = a[i];
        a[i] = a[LB];
        a[LB] = temp;
//        a[LB] = a[LB] - a[i];
//        a[i] = a[i] + a[LB];
//        a[LB] = a[i] - a[LB];
        return i;
    }

    public int part(int[] a, int LB, int UB) {
        int blockingElement = Integer.MAX_VALUE;
        int i = LB + 1, j = UB, aLen = a.length;
        int temp;
        int[] tempArray = new int[aLen + 1];
        for (int k = 0; k < aLen; k++) {
            tempArray[k] = a[k];
        }
        tempArray[aLen] = blockingElement;
        while (i <= j) {
            while (tempArray[i] < tempArray[LB]) {
                i++;
            }
            while (tempArray[j] > tempArray[LB]) {
                j--;
            }
            if (i <= j) {
                temp = tempArray[i];
                tempArray[i] = tempArray[j];
                tempArray[j] = temp;

                i++;
                j--;
            }
        }
          //fail when j = LB
//        a[LB] = a[LB] - a[j];
//        a[j] = a[j] + a[LB];
//        a[LB] = a[j] - a[LB];
        temp = tempArray[LB];
        tempArray[LB] = tempArray[j];
        tempArray[j] = temp;
        for (int l = 0; l < a.length; l++) {
            a[l] = tempArray[l];
        }
        return j;
    }

    //todo: swap function
//    public void swap(int a, int b) {
//        a = a - b;
//        b = b + a;
//        a = b - a;
//    }

//    public static void main(String [] args) {
//        int blockingElement = Integer.MAX_VALUE;
//        int[] a = new int[]{42, 23, 74, 11, 65, 58, 94, 36, 99, 87, 101};
//        int[] tempArray = new int[a.length + 1];
//        for (int i = 0; i < a.length; i++) {
//            tempArray[i] = a[i];
//        }
//        tempArray[a.length] = blockingElement;
//        System.out.println(Arrays.toString(tempArray));
//    }
}
