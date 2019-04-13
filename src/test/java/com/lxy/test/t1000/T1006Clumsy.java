package com.lxy.test.t1000;

import org.junit.Test;

/**
 * 笨阶乘
 * 将正常阶乘的‘*’用固定顺序的‘*’、‘/’、‘+’、‘-’替换
 * clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1
 *
 * @author liuxinyun
 * @date 2019/4/13 21:58
 */
public class T1006Clumsy {

    @Test
    public void test() {
        System.out.println(clumsy(10));
    }

    public int clumsy(int N) {
        if (N < 3)
            return N;
        if (N == 3)
            return 6;
        int res = N * (N-1) / (N-2);
        N -= 3;
        boolean plus = true;
        while (N > 0) {
            if (plus) {
                res += N;
                N--;
                plus = false;
            }else {
                if (N < 3)
                    return res - N;
                if (N == 3)
                    return res - 3*2;
                res -= N * (N-1) / (N-2);
                N -= 3;
                plus = true;
            }
        }
        return res;
    }

}
