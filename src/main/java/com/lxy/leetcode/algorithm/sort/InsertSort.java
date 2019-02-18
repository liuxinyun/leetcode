package com.lxy.leetcode.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序：O(n^2)，稳定
 * 默认起始位置已排序。
 * 从待排序中依次取出元素，和已排序的从后往前进行一一比较，小于则该位置元素后移继续，大于则直接插入进行下一步。
 * 循环上步
 */

public class InsertSort {

    public void sort(int[] a){
        int temp;// 存储待排元素
        for (int i=1, j = i; i<a.length; j = ++i){
            if (a[j] < a[j-1]) {
                temp = a[i];
                while (j >= 1 && temp < a[j-1]){
                    a[j] = a[--j];
                }
                a[j] = temp;//插入
            }
        }
    }


    public static void main(String[] args) {
        int[] a = {6,4,5,2,9,1,8,3,7};
        InsertSort is = new InsertSort();
        is.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
