package com.lxy.leetcode.algorithm.sort;

import com.lxy.leetcode.util.ArrayUtil;

import java.util.Arrays;

/**
 * 选择排序：O(n^2)，不稳定
 * 在排序序列中找到最小元素，存放到排序序列的起始位置
 * 再从剩余未排序元素中继续寻找最小元素，然后放到排序序列末尾。
 * 以此类推，直到所有元素均排序完毕。
 */

public class SelectSort {

    public void sort(int[] a){
        int len = a.length;
        for (int i = 0; i < len-1; i++) {
            int min = i;
            //从未排序的数列中找最小
            for (int j = i + 1; j < len; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            if (min != i) {
                ArrayUtil.swap(a, min, i);
            }
        }
    }


    public static void main(String[] args) {
        int[] a = {6,4,5,2,9,1,8,3,7};
        SelectSort ss = new SelectSort();
        ss.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
