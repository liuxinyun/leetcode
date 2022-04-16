package com.lxy.test.t300;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，
 * 返回一个长度为 n + 1 的数组 ans 作为答案。
 * 示例：
 * 输入：n = 5
 * 输出：[0,1,1,2,1,2]
 * 解释：
 * 0 --> 0   0
 * 1 --> 1   1
 * 2 --> 10  1
 * 3 --> 11  2
 * 4 --> 100  1
 * 5 --> 101  2
 *
 * @author liuxinyun
 * @date 2022/4/8 22:10
 */
public class T0338CountBits {

    @Test
    public void test() {
        Arrays.stream(countBits(9)).forEach(System.out::println);
    }

    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            // 1. 每个数字都算一遍, O(n*lgn)
            // res[i] = countOnes(i);
            // 2. 使用动态规划，O(n)
            // res[i] = res[i & (i - 1)] + 1;
            // 3. 根据奇偶判断，奇数比前面的偶数多1，偶数一定和自己的一半相等，O(n)
            if (i % 2 == 0) {
                res[i] = res [i >> 1];
            } else {
                res[i] = res[i - 1] + 1;
            }
        }
        return res;
    }

    private int countOnes(int n) {
        int countOnes = 0;
        while (n > 0) {
            // 最后一位1会变成0，多次计算，直到全为0
            n = n & (n - 1);
            countOnes++;
        }
        return countOnes;
    }

}
