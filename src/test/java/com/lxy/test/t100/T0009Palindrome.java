package com.lxy.test.t100;

import org.junit.Test;

/**
 * @author liuxinyun
 * @date 2019/4/4 22:32
 */
public class T0009Palindrome {

    @Test
    public void test() {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(10));
    }

    private boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int temp = x;
        int r = 0;
        while (temp > 0) {
            r = r * 10 + temp % 10;
            temp /= 10;
        }
        return r == x;
    }
}
