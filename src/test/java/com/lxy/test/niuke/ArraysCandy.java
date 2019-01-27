package com.lxy.test.niuke;

import org.junit.Test;

/**
 * @author liuxinyun
 * @date 2019/1/26 13:42
 */
public class ArraysCandy {

    @Test
    public void test() {
        int[] ratings = {1, 2, 1, 3, 4, 3};
        System.out.println(candy(ratings));
    }

    /**
     * 从做往右检查一遍，再从又往左检查一遍
     */
    private int candy(int[] ratings) {
        if (ratings==null || ratings.length==0)
            return 0;
        int len = ratings.length;
        int[] temp = new int[len];
        temp[0] = 1;
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i-1])
                temp[i] = temp[i-1] + 1;
            else
                temp[i] = 1;
        }
        int sum = 0;
        for (int i = len-1; i>0; i--) {
            if (ratings[i-1] > ratings[i] && temp[i] >= temp[i-1])
                temp[i-1] = temp[i] + 1;
            sum += temp[i];
        }
        sum += temp[0];
        return sum;
    }
}
