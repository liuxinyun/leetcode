package com.lxy.test.t800;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给定一个矩阵 A， 返回 A 的转置矩阵。
 *
 * 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 *
 * @author liuxinyun
 * @date 2019/5/12 11:44
 */
public class T0867Transpose {

    @Test
    public void test() {
        int[][] A = {{1,2,3},{4,5,6}};
        int[][] B = transpose(A);
        for (int[] ints : B) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public int[][] transpose(int[][] A) {
        int rLength = A.length;
        int cLength = A[0].length;
        int[][] res = new int[cLength][rLength];
        for (int i = 0; i < cLength; i++) {
            for (int j = 0; j < rLength; j++) {
                res[i][j] = A[j][i];
            }
        }
        return res;
    }

}
