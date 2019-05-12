package com.lxy.test.t200;

/**
 * @author liuxinyun
 * @date 2019/5/12 15:24
 */
public class T0263IsUgly {

    public boolean isUgly(int num) {
        if (num <= 0 ) {
            return false;
        }
        if (num < 7) {
            return true;
        }
        while (num%2==0 || num%3==0 || num%5==0) {
            if (num%2 ==0) {
                num /= 2;
            }else if (num%3 == 0) {
                num /= 3;
            }else {
                num /= 5;
            }
        }
        return num == 1;
    }
}
