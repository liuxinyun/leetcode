package com.lxy.test.niuke;

import com.lxy.leetcode.common.TreeNode;
import com.lxy.leetcode.util.ArrayUtil;
import org.junit.Test;

import java.util.*;

/**
 * 树遍历
 *
 * @author liuxinyun
 * @date 2019/1/13 11:53
 */
public class TreeTraversal {

    private List<Integer> result = new ArrayList<>();

    @Test
    public void test() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        t2.left = t1;
        t2.right = t3;
        t5.right = t6;
        t4.left = t2;
        t4.right = t5;
        List<Integer> list = unRecursiveInOrderTraversal(t4);
        ArrayUtil.printList(list);
    }

    /**
     * 递归后序遍历：左->右->父
     */
    private List<Integer> postOrderTraversal(TreeNode root) {
        if (root == null)
            return result;
        if (root.left != null)
            postOrderTraversal(root.left);
        if (root.right != null)
            postOrderTraversal(root.right);
        result.add(root.val);
        return result;
    }

    /**
     * 非递归后序遍历
     * 利用栈的先进后出的特性
     */
    private List<Integer> unRecursivePostOrderTraversal(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        if (root == null)
            return out;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()) {
            TreeNode temp = s1.pop();
            if (temp.left != null)
                s1.push(temp.left);
            if (temp.right != null)
                s1.push(temp.right);
            s2.push(temp.val);
        }
        while (!s2.isEmpty())
            out.add(s2.pop());
        return out;
    }

    /**
     * 递归先序遍历：父->左->右
     */
    private List<Integer> preOrderTraversal(TreeNode root) {
        if (root == null)
            return result;
        result.add(root.val);
        if (root.left != null)
            preOrderTraversal(root.left);
        if (root.right != null)
            preOrderTraversal(root.right);
        return result;
    }

    /**
     * 非递归先序遍历
     * 利用栈的先进后出的特性
     */
    private List<Integer> unRecursivePreOrderTraversal(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        if (root == null)
            return out;
        Stack<TreeNode> s1 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()) {
            TreeNode temp = s1.pop();
            out.add(temp.val);
            if (temp.right != null)
                s1.push(temp.right);
            if (temp.left != null)
                s1.push(temp.left);
        }
        return out;
    }

    /**
     * 递归中序遍历：左->父->右
     */
    private List<Integer> inOrderTraversal(TreeNode root) {
        if (root == null)
            return result;
        if (root.left != null)
            inOrderTraversal(root.left);
        result.add(root.val);
        if (root.right != null)
            inOrderTraversal(root.right);
        return result;
    }

    /**
     * 非递归中序遍历
     * 利用栈的先进后出的特性
     */
    private List<Integer> unRecursiveInOrderTraversal(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        if (root == null)
            return out;
        Stack<TreeNode> s1 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()) {
            // 最重要的是判断结点p有没有左结点,若有则p.left进栈,并使p.left=null,
            // 否则先将该节点从栈中删除，并将p.val保存到链表中,
            // 判断p.right是否为null 若不为null则把p.right进栈
            TreeNode p = s1.peek();
            if (p.left == null) {
                s1.pop();
                out.add(p.val);
                if (p.right != null)
                    s1.push(p.right);
            }else {
                s1.push(p.left);
                p.left = null;
            }
        }
        return out;
    }

    /**
     * 不使用递归和栈遍历
     * 使用线索树的思想
     *
     * @param root
     */
    private List<Integer> morrisTraversal(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        if (root == null) {
            return out;
        }
        TreeNode cur,pre;
        cur = root;
        while (cur != null){
            if (cur.left == null) {
                out.add(cur.val);
                cur = cur.right;
            }else {
                // 找前驱节点
                pre = cur.left;
                while (pre.right != null && pre.right !=cur) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                }else {
                    pre.right = null;
                    out.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return out;
    }

}
