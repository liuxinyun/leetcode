package com.lxy.test.t100;

import com.lxy.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 层次遍历二叉树
 *
 * @author liuxinyun
 * @date 2019/4/4 23:01
 */
public class T0102LevelOrderTree {

    private List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>(size);
            while (size > 0) {
                TreeNode p = queue.poll();
                if (p.left != null) queue.add(p.left);
                if (p.right != null) queue.add(p.right);
                temp.add(p.val);
                size--;
            }
            res.add(temp);
        }
        return res;
    }

}
