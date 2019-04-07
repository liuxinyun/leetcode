package com.lxy.test.t100;

import com.lxy.leetcode.common.TreeNode;

/**
 * 构建树
 *
 * @author liuxinyun
 * @date 2019/4/5 10:02
 */
public class T0106BuildTreePost {

    /**
     * 根据中序遍历和后序遍历构建
     * @param inorder 中序
     * @param postorder 后序
     * @return 树
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, 0, postorder.length, 0);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int postStart, int length, int inStart) {
        if (length == 0) return null;
        int rootVal = postorder[postStart+length-1];
        TreeNode root  = new TreeNode(rootVal);
        // 左子树节点数量
        int count = 0;
        while (count < length) {
            if (inorder[inStart+count] == rootVal) break;
            count++;
        }
        // 中序：左子树节点->根节点->右子树节点
        // 后序：左子树节点->右子树节点->根节点
        root.left = buildTree(inorder, postorder, postStart, count, inStart);
        root.right = buildTree(inorder, postorder, postStart+count, length-1-count, inStart+count+1);
        return root;
    }

}
