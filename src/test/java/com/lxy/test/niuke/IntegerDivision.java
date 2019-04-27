package com.lxy.test.niuke;

import org.junit.Test;

/**
 * 计算两个整数的除法，不能使用除法
 * 使用移位二分乘法代替
 *
 * @author liuxinyun
 * @date 2019/4/19 23:24
 */
public class IntegerDivision {


    @Test
    public void test() {
        System.out.println(div(10, 0));
        System.out.println(div(-10, 3));
    }

    public static int div(int a, int b) {
        if (b == 0) {
            return ~(1<<31);
        }
        boolean negative = false;
        if (a * b < 0) {
            a = Math.abs(a);
            b = Math.abs(b);
            negative = true;
        }
        int res = 0;
        while (b <= a) {
            int multi = 1;
            while (b*multi <= a>>1) {
                multi <<= 1;
            }
            res += multi;
            a -= b*multi;
        }
        if (negative) {
            res = -res;
        }
        return res;
    }
}
