package com.company;

import java.util.Arrays;

public class MergeSort {
  public int[] StraightMergeSort(int[] a) {
	int l = 1;
	int aLen = a.length;
	int[] result = new int[aLen];
	while (l< aLen) {
		MergeSections(a, l, result);
		MergeSections(result, 2*l, a);
		l = 4*l;
	}
	return a;
  }

  /**
   * MergeSections: merge sections with length l (the last section can be shorter than l)	 *
   */
  public int[] MergeSections(int[] a, int l, int[] result) {
	int aLen = a.length;
	int Q = aLen / (2*l);
	int S = 2*l*Q;
	int R = aLen - S;
	for (int i = 0; i<Q; i++) {
		int LB = 2*l*i;
		MergeSectionBySection(a, l, LB, a, l, LB+l, result, LB);
	}

	//only the last section left
	if (R < l) {
		for (int i = 0; i<R; i++) {
			result[S+i] = a[S+i];
		}
	}

	//2 sections left (1 with the length l & 1 shorter)
	else {
		MergeSectionBySection(a, l, S, a, R-l, S+l, result, S);
	}
	return result;
  }

	/**
	 * Merge 2 sections: 1 section with length l1, from LBA position and
	 *   the other section with the length l2, from LBB position
	 *   result saved in array result, from LBR position	 *
	 */
  public int[] MergeSectionBySection(int[] a, int l1, int LBA, int[] b, int l2, int LBB, int[] result, int LBR) {
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

  public static void main(String[] args) {
	MergeSort ms = new MergeSort();
	int[] initial = new int[] {12,10,15,6,2,7,8,1,3,9,5};
	System.out.println("Before sorted");
	System.out.println(Arrays.toString(initial));
	System.out.println("After sorted");
	int[] result = ms.StraightMergeSort(initial);
	System.out.println(Arrays.toString(result));
  }
}