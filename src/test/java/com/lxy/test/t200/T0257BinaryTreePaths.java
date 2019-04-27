package com.lxy.test.t200;

import com.lxy.leetcode.common.TreeNode;

import java.util.*;

/**
 * 二叉树的所有路径
 *
 * @author liuxinyun
 * @date 2019/4/15 22:36
 */
public class T0257BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        if (root==null)
            return new ArrayList<>();
        String path = ""+root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Map<TreeNode, String> map = new HashMap<>();
        map.put(root, path);
        List<String> res = new LinkedList<>();
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            String tempPath = map.get(temp);
            if (temp.left==null && temp.right==null)
                res.add(tempPath);
            if (temp.left != null) {
                queue.add(temp.left);
                map.put(temp.left, tempPath+"->"+temp.left.val);
            }
            if (temp.right != null) {
                queue.add(temp.right);
                map.put(temp.right, tempPath+"->"+temp.right.val);
            }
            map.remove(temp);
        }
        return res;
    }

    /**
     * 递归实现
     */
    public List<String> recursive(TreeNode root) {
        List<String> res = new LinkedList<>();
        if (root==null)
            return res;
        if (root.left==null && root.right==null) {
            res.add(root.val+"");
            return res;
        }
        List<String> left = recursive(root.left);
        for (String s : left) {
            res.add(root.val+"->"+s);
        }
        List<String> right = recursive(root.right);
        for (String s : right) {
            res.add(root.val+"->"+s);
        }
        return res;
    }


}
