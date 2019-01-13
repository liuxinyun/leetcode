package com.lxy.test.niuke;

import com.lxy.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 求树的最小深度
 *
 * @author liuxinyun
 * @date 2019/1/12 12:04
 */
public class TreeMinDepth {


    /**
     * 递归，深度遍历
     */
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left==0 || right==0) return left+right+1;
        return 1 + (left < right ? left : right);
    }

    /**
     * 非递归，层序广度遍历
     */
    private int bfs(TreeNode root) {
        if (root == null) return 0;
        if (root.left==null && root.right==null) return 1;
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i=0; i<size; i++) {
                TreeNode temp = queue.poll();
                if (temp.left==null && temp.right==null)
                    return depth;
                if (temp.left!=null)
                    queue.offer(temp.left);
                if (temp.right!=null)
                    queue.offer(temp.right);
            }
        }
        return 0;
    }
}
