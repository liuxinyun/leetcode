package com.lxy.test.t200;

import com.lxy.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liuxinyun
 * @date 2019/4/5 9:45
 */
public class T0104MaxDepthTree {

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            while (size > 0) {
                TreeNode p = queue.poll();
                if (p.left != null) queue.add(p.left);
                if (p.right != null) queue.add(p.right);
                size--;
            }
        }
        return depth;
    }

    // 递归实现
    private int maxDepthRecursive(TreeNode root) {
        if(root == null){
            return 0;
        }else if(root.left==null && root.right==null){
            return 1;
        }else{
            return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
        }
    }
}
