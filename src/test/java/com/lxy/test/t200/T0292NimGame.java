package com.lxy.test.t200;

/**
 * @author liuxinyun
 * @date 2019/4/6 8:13
 */
public class T0292NimGame {


    /**
     * 判断先手是否有必赢策略
     * 先手只需要拿走若干，使剩下的总数是(q+1)的倍数即可，这样无论对手拿多少m，都拿(q+1-m)个即可稳赢。
     * 同理如果是后手，那总数必须是(q+1)的倍数，才有稳赢策略
     *
     * @param n 总数
     * @param q 每次最多可以拿的数量，最小是1
     * @return true：先手必赢
     */
    public boolean canWinNim(int n, int q) {
        return n % (q+1) != 0;
    }

}
