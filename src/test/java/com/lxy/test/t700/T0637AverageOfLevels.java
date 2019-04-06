package com.lxy.test.t700;

import com.lxy.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 层次遍历二叉树——取每层平均值
 *
 * @author liuxinyun
 * @date 2019/4/4 23:01
 */
public class T0637AverageOfLevels {

    private List<Double> averageOfLevels(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Double> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0;
            int temp = size;
            while (temp > 0) {
                TreeNode p = queue.poll();
                if (p.left != null) queue.add(p.left);
                if (p.right != null) queue.add(p.right);
                sum += p.val;
                temp--;
            }
            res.add(1.0 * sum / size);
        }
        return res;
    }

}
