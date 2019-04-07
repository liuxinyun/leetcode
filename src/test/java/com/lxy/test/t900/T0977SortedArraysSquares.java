package com.lxy.test.t900;

import org.junit.Test;

import java.util.Arrays;

/**
 * 有序数组平方
 *
 * @author liuxinyun
 * @date 2019/4/7 15:50
 */
public class T0977SortedArraysSquares {

    @Test
    public void test() {
        int[] a = {-4, 1, 0, 3, 10};
        System.out.println(Arrays.toString(sortedSquares(a)));
        int[] a1 = {-7, -3, 2, 3, 11};
        System.out.println(Arrays.toString(sortedSquares(a1)));
    }

    public int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        int i = 0;
        int j = A.length-1;
        int k = res.length-1;
        while (i <= j) {
            if (A[i]*A[i] > A[j]*A[j]) {
                res[k] = A[i]*A[i];
                i++;
            }else {
                res[k] = A[j]*A[j];
                j--;
            }
            k--;
        }
        return res;
    }

}
