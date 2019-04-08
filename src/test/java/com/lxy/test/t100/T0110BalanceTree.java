package com.lxy.test.t100;

import com.lxy.leetcode.common.TreeNode;

/**
 * 判断是否是平衡二叉树
 *
 * @author liuxinyun
 * @date 2019/4/7 22:05
 */
public class T0110BalanceTree {

    public boolean isBalanced(TreeNode root) {
        // a. 使用定义，进行递归调用。缺点：求树的深度时要多次递归，平衡性也要递归。
//        if (root == null)
//            return true;
//        if (Math.abs(getDepth(root.left) - getDepth(root.right)) > 1) {
//            return false;
//        }
//        return isBalanced(root.left) && isBalanced(root.right);
        // b. 巧妙利用求树的深度中的递归调用，用-1表示该树是非平衡的。
        // 可以发现，当某个左子树或者右子树已经为-1时，即可快速返回。
        return depth(root) != -1;
    }

    private int getDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }

    private int depth(TreeNode root) {
        if (root == null)
            return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        if (left==-1 || right==-1 || Math.abs(left-right)>1)
            return -1;
        return 1 + Math.max(left, right);
    }

}
