package com.lxy.test.t200;

import com.lxy.leetcode.common.ListNode;

/**
 * @author liuxinyun
 * @date 2019/4/24 22:34
 */
public class T0206ListReverse {

    /**
     * 反转链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head==null || head.next==null) {
            return head;
        }
        ListNode cur = head.next;
        head.next = null;
        ListNode temp;
        while (cur != null) {
            temp = cur.next;
            cur.next = head;
            head = cur;
            cur = temp;
        }
        return head;
    }
}
