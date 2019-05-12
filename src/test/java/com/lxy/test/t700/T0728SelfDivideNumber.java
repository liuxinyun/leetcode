package com.lxy.test.t700;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 自除数：可以被每一位除尽
 *
 * @author liuxinyun
 * @date 2019/5/12 17:19
 */
public class T0728SelfDivideNumber {

    @Test
    public void test() {
        System.out.println(selfDividingNumbers(1, 22));
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new LinkedList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDivide(i)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean isSelfDivide(int num) {
        if (num == 0) {
            return false;
        }
        num = Math.abs(num);
        if (num < 10) {
            return true;
        }
        int temp = num;
        while (temp > 0) {
            int mod = temp % 10;
            if (mod == 0) {
                return false;
            }
            if (num % mod == 0) {
                temp /= 10;
            }else {
                return false;
            }
        }
        return true;
    }
}
