package com.lxy.test.t500;

import com.lxy.leetcode.common.TreeNode;

/**
 * 二叉树的坡度
 * 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
 * 整个树的坡度就是其所有节点的坡度之和。
 *
 * @author liuxinyun
 * @date 2019/4/14 18:09
 */
public class T0563FindTilt {

    private int res = 0;

    public int findTilt(TreeNode root) {
        if (root == null)
            return 0;
        sum(root);
        return res;
    }

    /***
     * 在递归求和的过程中把每个节点的坡度加进去，最终得到整棵树的坡度
     */
    private int sum(TreeNode root) {
        if (root == null)
            return 0;
        int left = sum(root.left);
        int right = sum(root.right);
        res += Math.abs(left-right);
        return root.val + left + right;
    }

}
