package com.company;

public class QuickSort {
    //todo: swap method in java

    public int[] sort(int[] a) {
        return QuickSort(a, 0, a.length-1);
    }
    /**
     * Quicksort: sort array a,
     * @param LB - lower bound
     * @param UB - upper bound
     */
    public int[] QuickSort(int[] a, int LB, int UB) {
        int aLen = a.length;
        if (LB <UB) {
//            int j = Partioning(a, LB, UB);
            int j = PartioningBy2Pointers(a, LB, UB);
            QuickSort(a, LB, j-1);
            QuickSort(a, j+1, UB);
        }
        return a;
    }
    //todo: use 2-pointer technique in quick sort
    public int PartioningBy2Pointers(int[]a, int LB, int UB) {
        int i = LB + 1, temp;
        for (int j = LB+1; j <= UB; j++) {
            if (a[j] <= a[LB]) {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
            }
        }
        i = i-1;
        temp = a[i];
        a[i] = a[LB];
        a[LB] = temp;
        return i;
    }

    public int Partioning(int[] a, int LB, int UB) {
        int i = LB + 1, j = UB;
        int temp;
        while (i <= j) {
            while (a[i] < a[LB]) {
                i++;
            }
            while (a[j] > a[LB]) {
                j--;
            }
            if (i < j) {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
        temp = a[LB];
        a[LB] = a[j];
        a[j] = temp;
        return j;
    }

    public void swap(int a, int b) {
        a = a - b;
        b = b + a;
        a = b - a;
    }
}
