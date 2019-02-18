package com.lxy.leetcode.util;

import java.util.List;

/**
 * @author liuxinyun
 * @date 2018/9/19 0:23
 */
public class ArrayUtil {

    public static void printList(List<Integer> list) {
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void swap(int[] array, int index1, int index2) {
        array[index1] = array[index1] + array[index2];
        array[index2] = array[index1] - array[index2];
        array[index1] = array[index1] - array[index2];
    }

}
