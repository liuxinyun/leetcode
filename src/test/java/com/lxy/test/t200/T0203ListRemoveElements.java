package com.lxy.test.t200;

import com.lxy.leetcode.common.ListNode;

/**
 * @author liuxinyun
 * @date 2019/4/24 22:20
 */
public class T0203ListRemoveElements {

    /**
     * 移除链表中的指定值
     *
     * @param head 链表
     * @param val 指定值
     * @return 移除后的链表
     */
    public static ListNode remove(ListNode head, int val) {
        ListNode dump = new ListNode(-1);
        dump.next = head;
        ListNode cur = dump;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return dump.next;
    }

}
