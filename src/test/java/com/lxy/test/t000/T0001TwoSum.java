package com.lxy.test.t000;

import com.lxy.leetcode.util.ArrayUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuxinyun
 * @date 2018/9/19 0:18
 */
public class T0001TwoSum {

    @Test
    public void sum(){
        int[] nums = {2, 11, 7, 15};
        int target = 9;
        int[] ints = onePassHash(nums, target);
        ArrayUtil.printArray(ints);
    }

    private int[] force(int[] nums, int target) {
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

    private int[] onePassHash(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)){
                return new int[]{map.get(temp), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
