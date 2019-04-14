package com.lxy.test.t200;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * 进阶：可以在常数空间复杂度内完成这个题目吗？
 *
 * @author liuxinyun
 * @date 2019/4/14 18:40
 */
public class T0238ProductExceptSelf {

    @Test
    public void test(){
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    /**
     * 巧妙计算每个元素的左右乘积，最终每个元素左右乘积相乘得出结果。
     * 时间复杂度O(n),空间复杂度O(1)。
     */
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        Arrays.fill(res, 1);
        //左侧连续乘积
        int left_multi = 1;
        //右侧连续乘积
        int right_multi = 1;
        for (int i = 0; i < length; i++) {
            res[i] *= left_multi;
            left_multi *= nums[i];

            res[length-1-i] *= right_multi;
            right_multi *= nums[length-1-i];
        }
        return res;
    }

    public int[] product2(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        int temp = 1;
        // 先从左侧乘积并赋值
        for (int i = 0; i < length; i++) {
            res[i] = temp;
            temp *= nums[i];
        }
        temp = 1;
        // 再乘右侧的
        for (int i = length-1; i >= 0; i--) {
            res[i] *= temp;
            temp *= nums[i];
        }
        return res;
    }

}
