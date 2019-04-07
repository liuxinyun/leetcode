package com.lxy.test.t900;

import com.lxy.leetcode.common.TreeNode;

/**
 * 单值二叉树
 *
 * @author liuxinyun
 * @date 2019/4/7 13:48
 */
public class T0965UnivalTree {

    public boolean isUnivalTree(TreeNode root) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;
        if (root.left != null && root.left.val != root.val)
            return false;
        if (root.right != null && root.right.val != root.val)
            return false;
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }

}
