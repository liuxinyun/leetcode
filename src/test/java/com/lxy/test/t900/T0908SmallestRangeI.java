package com.lxy.test.t900;

import org.junit.Test;

/**
 * 最小差值
 * 给定一个整数数组 A，对于每个整数 A[i]，我们可以选择任意 x 满足 -K <= x <= K，并将 x 加到 A[i] 中。
 * 在此过程之后，我们得到一些数组 B。
 * 返回 B 的最大值和 B 的最小值之间可能存在的最小差值。
 *
 * @author liuxinyun
 * @date 2019/4/9 22:48
 */
public class T0908SmallestRangeI {

    @Test
    public void test(){
        int[] a = {1};
        System.out.println(smallestRangeI(a, 0));
        int[] a1 = {0, 10};
        System.out.println(smallestRangeI(a1, 2));
    }

    public int smallestRangeI(int[] A, int K) {
        if (A.length < 2)
            return 0;
        int min = A[0], max = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] < min)
                min = A[i];
            if (A[i] > max)
                max = A[i];
        }
        return Math.max(0,max-min-2*K);
    }

}
