package com.lxy.test.onehundred.one;

import com.lxy.leetcode.util.ArrayUtil;
import org.junit.Test;

/**
 * @author liuxinyun
 * @date 2018/9/19 0:18
 */
public class TwoSum {

    @Test
    public void sum(){
        int[] nums = {2, 11, 7, 15};
        int target = 9;
        int[] ints = twoSum(nums, target);
        ArrayUtil.printArray(ints);
    }

    private int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
