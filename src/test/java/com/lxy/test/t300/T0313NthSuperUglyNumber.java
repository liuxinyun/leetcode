package com.lxy.test.t300;

import org.junit.Test;

/**
 * 编写一段程序来查找第 n 个超级丑数。
 *
 * 超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。
 *
 * @author liuxinyun
 * @date 2019/5/12 15:16
 */
public class T0313NthSuperUglyNumber {

    @Test
    public void test() {
        int[] primes = {2, 7, 13, 19};
        System.out.println(nthSuperUglyNumber(12, primes));
    }

    /**
     * 找出第n个丑数
     *
     * @param n
     * @return
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] res = new int[n];
        res[0] = 1;
        int[] uglyPrime = new int[primes.length];
        int next = 1;
        while (next < n) {
            int min = res[uglyPrime[0]] * primes[0];
            for (int i = 1; i < uglyPrime.length; i++) {
                if (res[uglyPrime[i]] * primes[i] < min) {
                    min = res[uglyPrime[i]] * primes[i];
                }
            }
            res[next] = min;
            next++;
            // 排除重复项
            for (int i = 0; i < uglyPrime.length; i++) {
                while (res[uglyPrime[i]] * primes[i] <= min) {
                    uglyPrime[i]++;
                }
            }
        }
        return res[n-1];
    }

}
