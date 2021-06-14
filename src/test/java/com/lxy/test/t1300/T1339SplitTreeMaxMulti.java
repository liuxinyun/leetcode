package com.lxy.test.t1300;

import com.lxy.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 分裂二叉树的最大乘积
 * 删除一条边，分裂成两颗子树，使子树节点和的乘积尽可能大
 *
 * @author liuxinyun
 * @date 2020/5/18 22:30
 */
public class T1339SplitTreeMaxMulti {

    public int maxProduct(TreeNode root) {
        // 先遍历整棵树求和
        int val = sum(root);
        List<Integer> list = new LinkedList<>();
        return 0;
    }


    public int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + sum(root.left) + sum(root.right);
    }

}
