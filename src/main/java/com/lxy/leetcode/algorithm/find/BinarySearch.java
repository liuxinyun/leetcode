package com.lxy.leetcode.algorithm.find;

import java.util.Arrays;

/**
 * 二分查找
 * 本例实现有两种实现，递归和循环，可参考Java官方实现
 *
 */

public class BinarySearch {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9};
        int search = Arrays.binarySearch(a, 4);
        System.out.println(search);
        int r1 = recur(a,5,0,a.length-1);
        System.out.println(r1);
        int r2 = unrecur(a,3);
        System.out.println(r2);
    }

    /**
     * 递归形式实现二分查找
     *
     * @param a
     * @param data
     * @param low
     * @param high
     * @return
     */
    public static int recur(int[] a, int data, int low, int high) {
        if (low > high || data < a[low] || data > a[high]) {
            return -1;
        }
        int middle = (low + high) >>> 1;
        if (data < a[middle]) {
            return recur(a, data, low, middle - 1);
        } else if (data > a[middle]) {
            return recur(a, data, middle + 1, high);
        } else {
            return middle;
        }
    }

    /**
     * 非递归实现二分查找
     *
     * @param a
     * @param data
     * @return
     */
    public static int unrecur(int[] a, int data) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int middle = (low + high) >>> 1;
            if (data < a[middle]) {
                high = middle - 1;
            } else if (data > a[middle]) {
                low = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
