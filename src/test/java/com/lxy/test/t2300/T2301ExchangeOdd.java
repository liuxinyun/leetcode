package com.lxy.test.t2300;

import org.junit.Test;

import java.util.Arrays;

/**
 * 交换奇偶顺序
 *
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 *
 * @author liuxinyun
 * @date 2022/4/9 17:34
 */
public class T2301ExchangeOdd {

    @Test
    public void test() {
        int[] exchange = exchange(new int[]{1, 2, 3, 4});
        Arrays.stream(exchange).forEach(System.out::println);
    }

    public int[] exchange(int[] nums) {
        int len = nums.length;
        int i = 0, j = len - 1;
        while (i < j) {
            if ((nums[i] & 1) == 1) {
                // 奇数跳过
                i++;
                continue;
            }
            if ((nums[j] & 1) == 0) {
                // 偶数跳过
                j--;
                continue;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }

}
