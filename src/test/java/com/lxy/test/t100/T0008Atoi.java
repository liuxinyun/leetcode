package com.lxy.test.t100;

import org.junit.Test;

/**
 * @author liuxinyun
 * @date 2019/4/3 22:37
 */
public class T0008Atoi {


    @Test
    public void test() {
        System.out.println(myAtoi("+0123"));
        System.out.println(myAtoi("-0123"));
        System.out.println(myAtoi("-0123liu"));
        System.out.println(myAtoi("liu0123"));
        System.out.println(myAtoi("-2147483649"));
        System.out.println(myAtoi("2147483648"));
    }

    private int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        char[] chars = str.trim().toCharArray();
        if (chars.length == 0) {
            return 0;
        }
        boolean flag = false;
        int start = 0;
        if (chars[0] == '-' || chars[0] == '+') {
            start = 1;
            if (chars[0] == '-') {
                flag = true;
            }
        }
        long res = 0;
        for (int i= start; i<chars.length; i++) {
            char t = chars[i];
            if (t < '0' || t > '9') {
                break;
            }
            res = res * 10 + (t - '0');
            if (flag) {
                if (-res < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            }else {
                if(res > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
            }
        }
        res  = flag ? -res : res;
        return (int)res;
    }
}
