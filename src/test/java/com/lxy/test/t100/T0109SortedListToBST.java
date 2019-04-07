package com.lxy.test.t100;

import com.lxy.leetcode.common.ListNode;
import com.lxy.leetcode.common.TreeNode;

/**
 * @author liuxinyun
 * @date 2019/4/7 14:54
 */
public class T0109SortedListToBST {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return new TreeNode(head.val);
        return buildBST(head, null);
    }

    private TreeNode buildBST(ListNode head, ListNode tail) {
        if (head == tail)
            return null;
        // 快慢指针求链表中间节点
        ListNode slow = head, fast = head;
        while (fast != tail && fast.next != tail){
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = buildBST(head, slow);
        root.right = buildBST(slow.next, tail);
        return root;
    }
}
