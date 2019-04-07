package com.lxy.test.t100;

import com.lxy.leetcode.common.TreeNode;

import java.util.*;

/**
 * 自底向上层次遍历二叉树
 *
 * @author liuxinyun
 * @date 2019/4/4 23:01
 */
public class T0107LevelOrderBottom {

    private List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Stack<List<Integer>> stack = new Stack<>();
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
            stack.push(temp);
        }
        List<List<Integer>> res = new ArrayList<>(stack.size());
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }

}
