package com.lxy.test.niuke;

import org.junit.Test;

/**
 * @author liuxinyun
 * @date 2019/1/26 11:46
 */
public class ArraysGasStation {

    @Test
    public void test() {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {5, 1, 2, 3, 4};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    private int canCompleteCircuit(int[] gas, int[] cost) {
        int N = gas.length;
        // 开始位置
        int start = 0;
        // 欠油量
        int lack = 0;
        // 剩余油量
        int remain = 0;
        for (int i = 0; i < N; i++) {
            remain += gas[i] - cost[i];
            if (remain < 0) {
                // 油量不足直接从当前位置的下一个位置开始
                // 不从上一次的开始位置和当前位置的中间某个位置开始的原因：开始位置剩油量一定大于等于0，
                // 到当前位置油量不足，那说明从上一次开始到当前，这中间从哪一位置开始到当前油量一定会
                // 不足，不需要再试。
                start = i + 1;
                lack += remain;
                remain = 0;
            }
        }
        return (lack + remain) >= 0 ? start : -1;
    }

}
