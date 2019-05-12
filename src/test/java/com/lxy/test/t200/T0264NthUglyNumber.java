package com.lxy.test.t200;

import org.junit.Test;

/**
 * 丑数：只包含质因数2,3,5的正整数
 *
 * @author liuxinyun
 * @date 2019/5/12 15:16
 */
public class T0264NthUglyNumber {

    @Test
    public void test() {
        System.out.println(nthUglyNumber(11));
    }

    /**
     * 找出第n个丑数
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        if (n < 7) {
            return n;
        }
        int[] res = new int[n];
        res[0] = 1;
        int ugly2 = 0, ugly3 = 0, ugly5 = 0;
        int next = 1;
        while (next < n) {
            int min = Math.min(Math.min(res[ugly2] * 2, res[ugly3] * 3), res[ugly5] * 5);
            res[next] = min;
            next++;
            // 排除重复项
            while (res[ugly2] * 2 <= min) {
                ++ugly2;
            }
            while (res[ugly3] * 3 <= min) {
                ++ugly3;
            }
            while (res[ugly5] * 5 <= min) {
                ++ugly5;
            }
        }
        return res[n-1];
    }

}
