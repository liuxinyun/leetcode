package com.lxy.test.t100;

import com.lxy.leetcode.common.TreeNode;

/**
 * 二叉树的最小深度
 *
 * @author liuxinyun
 * @date 2019/4/7 22:38
 */
public class T0111MinDepth {

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return root.left!=null && root.right!=null ? 1 + Math.min(left, right) : 1+left+right;
    }
}
