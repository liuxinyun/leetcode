package com.lxy.test.t100;

import com.lxy.leetcode.common.TreeNode;

/**
 * 判断从根到叶子是否有路径，使路径上所有节点的和等于给定值
 *
 * @author liuxinyun
 * @date 2019/4/7 23:03
 */
public class T0112HasPathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.left==null && root.right==null)
            return root.val == sum;
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }

}
