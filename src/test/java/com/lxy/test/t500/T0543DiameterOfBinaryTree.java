package com.lxy.test.t500;

import com.lxy.leetcode.common.TreeNode;

/**
 * 二叉树的直径：任意两个节点路径长度中的最大值，这条路径可能穿过根节点
 * 递归，自底向上遍历所有根节点，计算最大路径
 *
 * @author liuxinyun
 * @date 2019/4/7 13:14
 */
public class T0543DiameterOfBinaryTree {


    private int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        res = Math.max(res, getMaxDepth(root.left) + getMaxDepth(root.right));
        return res;
    }

    private int getMaxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(getMaxDepth(root.left), getMaxDepth(root.right));
    }

}
