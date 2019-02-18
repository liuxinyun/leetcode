package com.lxy.leetcode.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序：O(n*log(n))，不稳定
 * 把第零个位置看做中轴，和最后一个比，如果比它小交换，比它大不做任何处理。
 * 交换了以后再和小的那端比，比它小不交换，比他大交换。
 * 循环往复，一趟排序完成，左边就是比中轴小的，右边就是比中轴大的。
 * 对左右重复上述步骤。
 */

public class FastSort {

    /**
     * 一个方法实现快速排序
     *
     * @param a
     * @param left
     * @param right
     */
    public void sort1(int[] a, int left, int right){
        if (left >= right) {
            return;
        }
        int less = left;
        int great = right;
        int pivot = a[left];

        // 挖坑法
        while (great > less) {
            while (great > less && a[great] >= pivot) {
                --great;
            }
            if (great > less) {
                a[less++] = a[great];
            }

            while (great > less && a[less] <= pivot) {
                ++less;
            }
            if (great > less) {
                a[great--] = a[less];
            }
        }
        a[great] = pivot;

        // 双指针法
        /*while (great > less) {
            while (great > less && a[great] >= pivot) {
                --great;
            }
            while (great > less && a[less] <= pivot) {
                ++less;
            }
            if (great > less){
                ArrayUtil.swap(a, less, great);
            }
        }
        // 最终将基数归位
        a[left] = a[less];
        a[less] = pivot;*/

        // 模仿DualPivotQuicksort源码所写
        /*for (int k = less; k <= great; ++k){
            if (a[k] == pivot) {
                continue;
            }
            int ak = a[k];
            if (ak < pivot) {
                a[k] = a[less];
                a[less] = ak;
                ++less;
            }else {
                while (a[great] > pivot) {
                    --great;
                }
                if (a[great] < pivot) {
                    a[k] = a[less];
                    a[less] = a[great];
                    ++less;
                }else {
                    a[k] = pivot;
                }
                a[great] = ak;
                --great;
            }
        }*/

        sort1(a,left,less-1);
        sort1(a, great+1, right);
    }

    public static void main(String[] args) {
        FastSort fs = new FastSort();
        int[] a = {6,4,5,2,9,1,8,3,7};
        fs.sort1(a, 0 , a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
