package com.lxy.leetcode.algorithm.sort;

import com.lxy.leetcode.util.ArrayUtil;

import java.util.Arrays;

/**
 * 堆排序：O(n*log(n))，不稳定（最好、最坏、平均复杂度一样）
 *
 * 堆是完全二叉树，有大顶堆、小顶堆两种（大顶堆是父节点不小于子节点，小顶堆反之），初始构建大顶堆
 * 利用大顶堆特性，每次取堆顶元素放在最后，对剩下元素重新构建大顶堆
 * 重复上述步骤
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] array = {6, 4, 5, 2, 9, 1, 8, 3, 7};

        System.out.print("Before:");
        System.out.println(Arrays.toString(array));

        heapSort(array);

        System.out.print("After :");
        System.out.println(Arrays.toString(array));
    }

    public static void heapSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        // 初始化，i从最后一个父节点开始调整，构建最大堆
        int length = array.length;
        for (int i = length >> 1; i >= 0; i--) {
            maxHeap(array, i, length-1);
        }

        System.out.print("第0趟：");
        System.out.println(Arrays.toString(array));

        for (int i = length - 1; i > 0; i--) {
            ArrayUtil.swap(array, 0, i);
            maxHeap(array, 0, i-1);
            System.out.print("第" + (length-i) + "趟：");
            System.out.println(Arrays.toString(array));
        }
    }

    private static void maxHeap(int[] a, int parent, int end) {
        // 保存当前父节点的值
        int temp = a[parent];
        // 先选取左孩子
        int child = parent * 2 + 1;

        // 若子节点指标在范围内才做比较
        while (child <= end) {
            // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
            if (child + 1 <= end && a[child] < a[child + 1]) {
                // 先比较两个子节点大小，选择大的
                child++;
            }
            if (temp >= a[child]) {
                // 如果父节点大于等于子节点代表调整完毕
                break;
            }
            // 否则把子节点的值交给父节点，继续向下比较
            a[parent] = a[child];
            parent = child;
            child = 2 * parent + 1;
        }
        a[parent] = temp;
    }

}
