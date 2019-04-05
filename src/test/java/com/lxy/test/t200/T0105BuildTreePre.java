package com.lxy.test.t200;

import com.lxy.leetcode.common.TreeNode;

/**
 * 构建树
 *
 * @author liuxinyun
 * @date 2019/4/5 10:02
 */
public class T0105BuildTreePre {

    /**
     * 根据前序遍历和中序遍历构建
     * @param preorder 前序
     * @param inorder 中序
     * @return 树
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length, 0);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int length, int inStart) {
        if (length == 0) return null;
        int rootVal = preorder[preStart];
        TreeNode root  = new TreeNode(rootVal);
        // 左子树节点数量
        int count = 0;
        while (count < length) {
            if (inorder[inStart+count] == rootVal) break;
            count++;
        }
        // 前序：根节点->左子树节点->右子树节点
        // 中序：左子树节点->根节点->右子树节点
        root.left = buildTree(preorder, inorder, preStart+1, count, inStart);
        root.right = buildTree(preorder, inorder, preStart+count+1, length-count-1, inStart+count+1);
        return root;
    }

}
