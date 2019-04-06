package com.lxy.test.t400;

/**
 * 给定一个正整数 n，你可以做如下操作：
 * 1. 如果 n 是偶数，则用 n / 2替换 n。
 * 2. 如果 n 是奇数，则可以用 n + 1或n - 1替换 n。
 * n 变为 1 所需的最小替换次数是多少？
 *
 * @author liuxinyun
 * @date 2019/4/6 10:09
 */
public class T0397IntegerReplace {

    public int integerReplacement(int m) {
        int count = 0;
        long n = m;
        while (n > 1) {
            if (n%2 == 0)
                n = n >> 1;
            else if (n==3 || (n>>1)%2 == 0)
                n--;
            else
                n++;
            count++;
        }
        return count;
    }

}
