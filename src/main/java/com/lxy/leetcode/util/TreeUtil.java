package com.lxy.leetcode.util;

import com.lxy.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liuxinyun
 * @date 2019/3/2 21:33
 */
public class TreeUtil {

    // 获取最大深度
    public static int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getMaxDepth(root.left);
        int right = getMaxDepth(root.right);
        return 1 + Math.max(left, right);
    }

    // 获取最大宽度
    public static int getMaxWidth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int maxWitdth = 1; // 最大宽度
        queue.add(root); // 入队
        while (!queue.isEmpty()) {
            // 当前层的节点个数
            int len = queue.size();
            while (len > 0) {
                // 如果当前层，还有节点
                TreeNode t = queue.poll();
                len--;
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
            maxWitdth = Math.max(maxWitdth, queue.size());
        }
        return maxWitdth;
    }

}
