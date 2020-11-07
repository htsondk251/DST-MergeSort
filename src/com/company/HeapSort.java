package com.company;

public class HeapSort {
    public int[] sort(int[] a) {
        int aHeapSize = a.length;
        int temp;
        build_max_heap(a);
        for (int i = a.length - 1 ; i >=1; i--) {
            temp = a[i];
            a[i] = a[0];
            a[0] = temp;
            aHeapSize--;
            max_heapify(a, aHeapSize, 0);
        }
        return a;
    }

    public int[] max_heapify(int[] a, int aHeapSize, int i) {
        int largest, temp;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < aHeapSize && a[left] > a[i]) {
            largest = left;
        } else {
            largest = i;
        }
        if (right < aHeapSize && a[right] > a[largest]) {
            largest = right;
        }
        if (largest != i) {
            temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            max_heapify(a, aHeapSize, largest);
        }
        return a;
    }

    public int[] build_max_heap(int[] a) {
        int aHeapSize = a.length;
        for (int i = (aHeapSize/2-1); i >= 0 ; i--) {
            max_heapify(a, aHeapSize, i);
        }
        return a;
    }
}

//    public int[] sort1(int[] nums) {
//        return heapSort(nums);
//    }
//
//    public int[] heapSort(int[] nums) {
//        int min = Integer.MAX_VALUE;
//        int max = Integer.MIN_VALUE;
//
//        for (int num : nums) {
//            if (num > max) {
//                max = num;
//            }
//            if (num < min) {
//                min = num;
//            }
//        }
//
//        int[] heap = new int[max - min + 1];
//
//        for (int num : nums) {
//            heap[num - min]++;
//        }
//
//        int[] result = new int[nums.length];
//        int index = 0;
//        for (int i = 0; i < max - min + 1; i++) {
//            if (heap[i] == 0) {
//                continue;
//            }
//            result[index] = i + min;
//            index++;
//        }
//        return result;
//    }
