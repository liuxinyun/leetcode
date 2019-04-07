package com.lxy.test.t600;

/**
 * 4个按钮的作用效果，考虑到后边再多灯泡也是重复前边灯泡的情况，将4个按钮效果用最少灯泡来表示
 * 1.将所有灯泡的状态反转（即开变为关，关变为开）：1个灯泡
 * 2.将编号为偶数的灯泡的状态反转：2个灯泡
 * 3.将编号为奇数的灯泡的状态反转：2个灯泡
 * 4.将编号为 3k+1 的灯泡的状态反转（k = 0, 1, 2, ...)：3个灯泡
 * 因此可转化为：n = n < 3 ? n : 3;
 * 一旦n >= 3,m >= 3,则可能情况就是3个灯泡的所有可能情况，每个灯泡2种情况，则总数是2^3=8种
 * 剩余极端情况，枚举即可
 *
 * @author liuxinyun
 * @date 2019/4/6 9:39
 */
public class T0672FlipLights {

    public int flipLights(int n, int m) {
        if (n == 0 || m == 0)
            return 1;
        if (n == 1)
            return 2;
        if (n == 2)
            return m==1 ? 3 : 4;
        if (m == 1)
            return 4;
        if (m == 2)
            return 7;
        return 8;
    }
}
