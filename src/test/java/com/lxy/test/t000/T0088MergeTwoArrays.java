package com.lxy.test.t000;

import org.junit.Test;

/**
 * @author liuxinyun
 * @date 2019/4/7 15:27
 */
public class T0088MergeTwoArrays {

    @Test
    public void test() {
        int[] nums1 = {4, 0, 0, 0};
        int[] nums2 = {1, 2, 3};
        merge(nums1, 1, nums2, 3);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1, k = m+n-1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            }else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        while (j >= 0) {
            nums1[j] = nums2[j--];
        }
    }
}
