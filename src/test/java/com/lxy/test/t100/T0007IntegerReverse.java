package com.lxy.test.t100;

import org.junit.Test;

/**
 * @author liuxinyun
 * @date 2019/4/1 23:14
 */
public class T0007IntegerReverse {


    @Test
    public void test() {
        System.out.println(reverse(-0));
    }

    public int reverse(int x) {
        int abs = Math.abs(x);
        int result = 0;
        while (abs != 0) {
            if (result > (Integer.MAX_VALUE - abs % 10) / 10) {
                //解决越界问题
                return 0;
            }
            //每一次都在原来结果的基础上变大10倍，再加上余数
            result = result * 10 + abs % 10;
            abs /= 10;
        }
        return x < 0 ? -result : result;
    }
}
