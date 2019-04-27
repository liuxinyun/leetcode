package com.lxy.test.t000;

import org.junit.Test;

/**
 * @author liuxinyun
 * @date 2019/4/24 22:24
 */
public class T0027ArraysRemoveElements {


    @Test
    public void test() {
        int[] nums = {3, 2, 2, 3};
        System.out.println(removeElement(nums, 2));
    }

    /**
     * 移除数组中的指定元素，不额外使用空间，超出新空间后的元素不考虑
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[res++] = nums[i];
            }
        }
        return res;
    }
}
