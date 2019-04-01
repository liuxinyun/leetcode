package com.lxy.test.t100;

import org.junit.Test;

/**
 * 寻找两个有序数组中位数
 * 考察转换为二分查找
 *
 * @author liuxinyun
 * @date 2019/3/30 23:08
 */
public class T0004FindMedianSortedArrays {

    @Test
    public void test() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    /**
     * 将两个数组分别在i和j位置分开，保证左边的个数等于右边的个数，有：i+j = m-i+n-j(或+1)
     * 即i=[0,m]，j=(m+n+1)/2-i，且有num1[i-1]<=num2[j]&&num2[j-1]<=num1[i]
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            // 确保第一个数组个数少
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int m = nums1.length;
        int n = nums2.length;
        int iMin = 0, iMax = m, halfLen = (m + n + 1) >> 1;
        while (iMin <= iMax) {
            int i = (iMin + iMax) >> 1;
            int j = halfLen - i;
            // 二分查找i，增大i表示j缩小，即可同时增大num1[i]并缩小num2[j-1]
            if (i < iMax && nums2[j - 1] > nums1[i]) {
                // i太小
                iMin = i + 1;
            }else if (i > iMin && nums1[i - 1] > nums2[j]) {
                // i太大
                iMax = i - 1;
            }else {
                // i正好
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j -1];
                }else if (j == 0) {
                    maxLeft = nums1[i-1];
                }else {
                    maxLeft = Math.max(nums1[i-1], nums2[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    // 奇数可直接返回
                    return maxLeft;
                }
                int minRight = 0;
                if (i == m) {
                    minRight = nums2[j];
                }else if (j == n) {
                    minRight = nums1[i];
                }else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }
                // 此处不能用移位表示除2，会直接取整，为了返回double，要除2.0。
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0d;
    }

}
