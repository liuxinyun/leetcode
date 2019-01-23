package com.lxy.test.niuke;

import org.junit.Test;

/**
 * 两个有序数组找中位数，直接使用归并排序中的归并
 *
 * @author liuxinyun
 * @date 2019/1/23 22:40
 */
public class ArraysSortedFindMedian {

    @Test
    public void test() {
        int[] a = {1, 2, 5};
        int[] b = {3, 4};
        System.out.println(findMedianSortedArrays(a, b));
    }

    /**
     * 找两个有序数组的中位数
     * @param A 有序数组A
     * @param B 有序数组B
     * @return 中位数
     */
    private double findMedianSortedArrays(int A[], int B[]) {
        int aLength = A.length;
        int bLength = B.length;
        int rLenght = aLength + bLength;
        int[] result = new int[rLenght];
        int i=0, j=0;
        int k = 0;
        while (i< aLength && j< bLength) {
            result[k++] = A[i] <= B[j] ? A[i++] : B[j++];
        }

        while (i< aLength) {
            result[k++] = A[i++];
        }
        while (j< bLength) {
            result[k++] = B[j++];
        }
        int mid = rLenght / 2;
        if (rLenght%2 == 0) {
            return (double) (result[mid-1] + result[mid])/2;
        }else {
            return result[mid];
        }
    }
}
