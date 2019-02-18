package com.lxy.leetcode.util;

import java.util.Arrays;

/**
 * @author liuxinyun
 * @date 2018/12/12 23:41
 */
public class SortUtil {

    public static void main(String[] args) {
        int[] a = {6,4,5,2,9,1,8,3,7};
        //bubbleSort(a);
        //selectSort(a);
        //insertSort(a);
        //shellSort(a);
        //fastSort(a, 0, a.length-1);
        //mergeSort(a, 0, a.length-1);
        heapSort(a);
        System.out.println(Arrays.toString(a));
    }

    // 交换数组中指定位置元素
    private static void swap(int[] a, int m, int n) {
        a[m] = a[m] + a[n];
        a[n] = a[m] - a[n];
        a[m] = a[m] - a[n];
    }

    // 快速排序
    public static void fastSort(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int i = low;
        int j = high;
        int temp = a[low];
        while (i < j) {
            while (i < j && a[j] >= temp) {
                j--;
            }
            if (i < j) {
                a[i++] = a[j];
            }
            while (i < j && a[i] <= temp) {
                i++;
            }
            if (i < j) {
                a[j--] = a[i];
            }
        }
        a[i] = temp;
        fastSort(a, low, i-1);
        fastSort(a, i+1, high);
    }

    // 冒泡排序
    public static void bubbleSort(int[] a) {
        int len = a.length;
        for (int i = len - 1; i>0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j+1]) {
                    swap(a, j, j+1);
                }
            }
        }
    }

    // 插入排序
    public static void insertSort(int[] a) {
        int len = a.length;
        int temp;// 存储待插入值
        for (int i = 1; i < len; i++) {
            int j = i;
            if (a[j] < a[j-1]) {
                temp = a[i];
                while (j >=1 && temp < a[j-1]) {
                    a[j] = a[--j];
                }
                a[j] = temp;// 插入
            }

        }
    }

    // 选择排序
    public static void selectSort(int[] a) {
        int len = a.length;
        for (int i = 0; i < len - 1; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (a[j] < a[min]) {
                min = j;
            }
        }
        if (min != i) {
            swap(a, i, min);
        }
    }
}

    // 希尔排序
    public static void shellSort(int[] a) {
        int len = a.length;
        for (int incr = len >> 1; incr > 0; incr /= 2) {
            int temp;// 存储待插入值
            for (int i = incr; i < len; i++) {
                int j = i;
                if (a[j] < a[j-incr]) {
                    temp = a[i];
                    while (j >= incr && temp < a[j-incr]) {
                        a[j] = a[j-incr];
                        j -= incr;
                    }
                    a[j] = temp;// 插入
                }

            }
        }
    }

    // 归并排序
    public static void mergeSort(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low+high) >> 1;
        mergeSort(a, low, mid);
        mergeSort(a, mid+1, high);
        merge(a, low, mid, high);
    }
    // 归并
    private static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high-low+1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            temp[k++] = a[i] < a[j] ? a[i++] : a[j++];
        }
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        while (j <= high) {
            temp[k++] = a[j++];
        }
        System.arraycopy(temp, 0, a, low, temp.length);
    }

    // 堆排序
    public static void heapSort(int[] a) {
        int len = a.length;
        // 初始化堆
        for (int i = len >> 1; i >= 0; i--) {
            maxHeap(a, i, len-1);
        }
        for (int i = len-1; i > 0; i--) {
            swap(a, 0, i);
            maxHeap(a, 0, i-1);
        }

    }
    // 构建大顶堆
    private static void maxHeap(int[] a, int parent, int end){
        int temp = a[parent];
        int child = 2 * parent + 1;
        while (child <= end) {
            while (child+1 <= end && a[child] < a[child+1]) {
                child++;
            }
            if (temp >= a[child]) {
                // 父节点大于等于子节点，代表调整完毕，退出
                break;
            }
            a[parent] = a[child];
            parent = child;
            child = 2 * parent + 1;
        }
        a[parent] = temp;
    }

}
