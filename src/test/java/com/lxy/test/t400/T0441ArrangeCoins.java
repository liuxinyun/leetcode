package com.lxy.test.t400;

import org.junit.Test;

/**
 * n枚硬币，阶梯排列，第k行正好有k枚硬币，返回能完整阶梯行的总行数
 *
 * @author liuxinyun
 * @date 2019/4/13 22:54
 */
public class T0441ArrangeCoins {

    @Test
    public void test() {
        System.out.println(arrangeCoins(1804289383));
    }

    public int arrangeCoins(int n) {
        long k = (int) Math.sqrt( 2d * n);
        long sum = k * (k+1) / 2;
        return sum <= n ? (int) k : (int) k-1;
    }

}
