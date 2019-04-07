package com.lxy.test.t100;

import com.lxy.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 对称二叉树
 *
 * @author liuxinyun
 * @date 2019/4/4 23:01
 */
public class T0101SymmetricTree {

    private boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode p1 = queue.poll();
            TreeNode p2 = queue.poll();
            if (p1==null && p2==null) continue;
            if (p1==null || p2==null) return false;
            if (p1.val != p2.val) return false;
            queue.add(p1.left);
            queue.add(p2.right);
            queue.add(p1.right);
            queue.add(p2.left);
        }
        return true;
    }

    /**
     * 镜像
     * @param t1 树1
     * @param t2 树2
     * @return true 两棵树是镜像树
     */
    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }

}
