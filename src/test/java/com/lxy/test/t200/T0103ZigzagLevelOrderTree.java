package com.lxy.test.t200;

import com.lxy.leetcode.common.TreeNode;

import java.util.*;

/**
 * 锯齿形层次遍历二叉树
 *
 * @author liuxinyun
 * @date 2019/4/4 23:01
 */
public class T0103ZigzagLevelOrderTree {

    private List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> res = new ArrayList<>();
        boolean flag = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>(size);
            Stack<Integer> stack = new Stack<>();
            while (size > 0) {
                TreeNode p = queue.poll();
                if (p.left != null) queue.add(p.left);
                if (p.right != null) queue.add(p.right);
                if (flag) {
                    stack.add(p.val);
                }else {
                    temp.add(p.val);
                }
                size--;
            }
            while (!stack.isEmpty()){
                temp.add(stack.pop());
            }
            res.add(temp);
            flag = !flag;
        }
        return res;
    }

}
