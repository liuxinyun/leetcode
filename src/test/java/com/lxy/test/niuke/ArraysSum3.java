package com.lxy.test.niuke;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组中找到三个数和为0的数
 *
 * @author liuxinyun
 * @date 2019/4/21 23:20
 */
public class ArraysSum3 {

    @Test
    public void test() {
        int[] nums = {2,1,0,-1,1,4,2,-2,-3};
        System.out.println(findSum3(nums));
    }

    private static List<List<Integer>> findSum3(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp;
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                // 固定i，根据条件逼近j和k
                if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                }else if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                }else {
                    temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    if (!list.contains(temp)) {
                        list.add(temp);
                    }
                    k--;
                }
            }
        }
        return list;
    }
}
