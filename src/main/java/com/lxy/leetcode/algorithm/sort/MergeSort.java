package com.lxy.leetcode.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序：O(n*log(n))，稳定（唯一一个又快又稳定的，且最好、最坏、平均复杂度一样），
 * 缺点：空间复杂度高，需要额外空间（临时数组）
 *
 * 1)把 n 个记录看成 n 个长度为1的有序子表；
 * 2)进行两两归并使记录关键字有序，得到 n/2 个长度为 2 的有序子表；
 * 3)重复第2)步直到所有记录归并成一个长度为 n 的有序表为止。
 */

public class MergeSort {

    public void sort(int[] a, int low, int high){
        if (low >= high) {
            return;
        }

        int middle = (low+high)>>1;
        //二路归并排序
        sort(a,low,middle);
        sort(a,middle+1,high);
        merge(a, low, middle, high);
    }

    private void merge(int[] a, int low, int middle, int high){
        int[] temp = new int[high-low+1];//临时存储归并后的序列
        int i = low;
        int j = middle+1;
        int k = 0;
        //将两个序列中较小的数归并到临时数组
        while (i<=middle && j<=high){
            temp[k++] = a[i] < a[j] ? a[i++] : a[j++];
        }
        //将左侧剩余的归并
        while (i<=middle) {
            temp[k++] = a[i++];
        }
        //将右侧剩余的归并
        while (j<=high) {
            temp[k++] = a[j++];
        }
        //将合并好的临时数组中的值覆盖到原数组
        System.arraycopy(temp, 0, a, low, temp.length);
    }

    public static void main(String[] args) {
        int[] a = {6,4,5,2,9,1,8,3,7};
        MergeSort ms = new MergeSort();
        ms.sort(a, 0 , a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
