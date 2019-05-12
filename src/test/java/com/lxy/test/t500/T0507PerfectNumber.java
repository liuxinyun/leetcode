package com.lxy.test.t500;

import org.junit.Test;

/**
 * 对于一个 正整数，如果它和除了它自身以外的所有正因子之和相等，我们称它为“完美数”。
 *
 * @author liuxinyun
 * @date 2019/5/12 17:32
 */
public class T0507PerfectNumber {

    @Test
    public void test() {
        System.out.println(checkPerfectNumber(0));
    }

    // 投机取巧：完美数真的好少。。。
    public boolean tjqx(int num) {
        return num == 6 || num == 28 || num == 496 || num == 8128 || num == 33550336;
    }

    public boolean checkPerfectNumber(int num) {
        if (num < 6) {
            return false;
        }
        int sum = 0;
        int mid = num >> 1;
        for (int i = 1; i <= mid; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return num == sum;
    }


}
