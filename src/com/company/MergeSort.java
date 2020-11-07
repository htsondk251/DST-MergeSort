package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
	public int[] sort(int[] a) {
		return StraightMergeSort(a);
//		return NaturalMergeSort(a);
	}

  public int[] StraightMergeSort(int[] a) {
	int l = 1;
	int aLen = a.length;
	int[] result = new int[aLen];
	while (l< aLen) {
		mergeSections(a, l, result);
		mergeSections(result, 2*l, a);
		l = 4*l;
	}
	return a;
  }

  /**
   * MergeSections: merge sections with length l (the last section can be shorter than l)	 *
   */
  //todo: remove result in passing argument
  public int[] mergeSections(int[] a, int l, int[] result) {
	int aLen = a.length;
	int Q = aLen / (2*l);
	int S = 2*l*Q;
	int R = aLen - S;
	for (int i = 0; i<Q; i++) {
		int LB = 2*l*i;
		mergeSectionBySection(a, l, LB, a, l, LB+l, result, LB);
	}

	//only the last section left
	if (R < l) {
		for (int i = 0; i<R; i++) {
			result[S+i] = a[S+i];
		}
	}

	//2 sections left (1 with the length l & 1 shorter)
	else {
		mergeSectionBySection(a, l, S, a, R-l, S+l, result, S);
	}
	  //        Shallow copy (not OK)
//        a = result.clone();
//        a = Arrays.copyOf(result, aLen);
//        a = result;

//        Deep copy (OK)
//	  for (int i = 0; i < result.length; i++) {
//		  a[i] = result[i];
//	  }
	return result;
  }

	/**
	 * Merge 2 sections: 1 section with length l1, from LBA position and
	 *   the other section with the length l2, from LBB position
	 *   result saved in array result, from LBR position	 *
	 */
  public int[] mergeSectionBySection(int[] a, int l1, int LBA, int[] b, int l2, int LBB, int[] result, int LBR) {
	int aLen = a.length;
	int bLen = b.length;
	int i = LBA, j = LBB, k = LBR;
	int UBA = LBA + l1;
	int UBB = LBB + l2;
	while (i < UBA && j < UBB) {
		if (a[i] <= b[j]) {
			result[k++] = a[i++];
		} else {
			result[k++] = b[j++];
		}
	}
	while (i < UBA) {
		result[k++] = a[i++];
	}
	while (j < UBB) {
		result[k++] = b[j++];
	}
	return result;
  }

	//todo: natural merge sort
	/**
	 * determine the natural sorted section
	 */
//	public List<Integer> determineSection(int[] a) {
//  		List<Integer> indexes = new ArrayList<>();
//		for (int i = 0; i < a.length-1; i++) {
//			if (a[i] > a[i+1]) {
//				indexes.add(i);
//			}
//		}
//		return indexes;
//	}

//	public int[] mergeSectionsInNatural(int[] a, List<Integer> indexes) {
//  		return null;
//	}
}