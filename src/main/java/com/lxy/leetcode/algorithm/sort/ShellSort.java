package com.lxy.leetcode.algorithm.sort;

import java.util.Arrays;

/**
 * 希尔排序：比O(n^2)略小，约为O(n^1.2)，不稳定
 * 以步长进行分组，并按插入从小到达排
 * 步长减半重复
 * 循环上步
 * 步长为一，插入排序
 */

public class ShellSort {

    public void sort(int[] a){
        int length = a.length;
        //每次将步长缩短为原来的一半
        for (int increment = length >>> 1; increment > 0; increment /= 2){
            //下面为一个插入排序
            for (int i = increment, j=i; i < length; j=++i){
                if (a[j] < a[j-increment]) {
                    int temp = a[i];//待排元素
                    while (j >= increment && temp < a[j-increment]){
                        a[j] = a[j - increment];
                        j -= increment;
                    }
                    a[j] = temp;
                }
            }

        }
    }


    public static void main(String[] args) {
        int[] a = {6,4,5,2,9,1,8,3,7};
        ShellSort ss = new ShellSort();
        ss.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
