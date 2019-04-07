package com.lxy.test.t100;

import com.lxy.leetcode.common.TreeNode;

/**
 * 有序数组转二叉搜索树
 *
 * @author liuxinyun
 * @date 2019/4/7 13:57
 */
public class T0108SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length-1);
    }

    private TreeNode buildBST(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = (low + high) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, low, mid -1);
        root.right = buildBST(nums, mid+1, high);
        return root;
    }

}
