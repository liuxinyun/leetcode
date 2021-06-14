package com.lxy.test.t100;


/**
 *
 * 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 链接：https://leetcode-cn.com/problems/majority-element
 *
 * @author liuxinyun
 * @date 2021/6/13 16:46
 */
public class T0169MajorityElement {

    public static void main(String[] args) {
        int[] nums = {2,1,1,1,2,3,3,2,1};
        System.out.println(majorityElement(nums));
    }

    /**
     * 摩尔投票打擂台，只要自己人不内斗，最终胜出的就是众数
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        int res = nums[0];
        if (nums.length == 1) {
            return res;
        }
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                // 攻擂成功，从1开始，设为当前值
                count = 1;
                res = nums[i];
                continue;
            }
            if (nums[i] == res) {
                count++;
            }else {
                count--;
            }
        }
        return res;
    }

}
