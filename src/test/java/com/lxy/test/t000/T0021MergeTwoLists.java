package com.lxy.test.t000;

import com.lxy.leetcode.common.ListNode;

/**
 * 合并两个有序链表
 *
 * @author liuxinyun
 * @date 2019/4/7 15:14
 */
public class T0021MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dumpHead = new ListNode(-1);
        ListNode head = dumpHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val){
                head.next = new ListNode(l1.val);
                l1 = l1.next;
            }else {
                head.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            head = head.next;
        }
        if (l1 != null)
            head.next = l1;
        if (l2 != null)
            head.next = l2;
        return dumpHead.next;
    }

}
