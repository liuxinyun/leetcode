package com.lxy.leetcode.algorithm.sort;

import com.lxy.leetcode.util.ArrayUtil;

import java.util.Arrays;

/**
 * 冒泡排序：O(n^2)，稳定
 * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
 * 针对所有的元素重复以上的步骤，除了最后一个。
 * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 */

public class BubbleSort {

    public void bubbleSort(int[] a){
        int len = a.length;
        for (int i = len - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    ArrayUtil.swap(a, j, j+1);
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] a = {6,4,5,2,9,1,8,3,7};
        BubbleSort bs = new BubbleSort();
        bs.bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }
}
