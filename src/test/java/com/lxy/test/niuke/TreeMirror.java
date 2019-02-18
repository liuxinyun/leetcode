package com.lxy.test.niuke;

import com.lxy.leetcode.common.TreeNode;

/**
 * @author liuxinyun
 * @date 2019/2/13 20:28
 */
public class TreeMirror {

    public void mirror(TreeNode root) {
        if(root==null)
            return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        mirror(left);
        mirror(right);
    }

}
