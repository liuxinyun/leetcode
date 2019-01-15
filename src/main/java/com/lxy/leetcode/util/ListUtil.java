package com.lxy.leetcode.util;

import com.lxy.leetcode.common.ListNode;

/**
 * @author liuxinyun
 * @date 2018/9/19 22:47
 */
public class ListUtil {

    /**
     * 打印链表
     * @param ln 链表
     */
    public static void printList(ListNode ln) {
        ListNode cur = ln;
        while (cur != null){
            System.out.print(cur.val);
            if ((cur=cur.next) != null) {
                System.out.print("->");
            }
        }
    }

    /**
     * 反转链表
     * @param ln 链表
     * @return 反转后的链表
     */
    public static ListNode convert(ListNode ln) {
        if (ln == null || ln.next == null) {
            return ln;
        }
        ListNode post = ln.next;
        ln.next = null;
        while (post != null) {
            ListNode tmp = post.next;
            post.next = ln;
            ln = post;
            post = tmp;
        }
        return ln;
    }

    /**
     * 获取中间节点
     * @param head 链表
     * @return 中间节点
     */
    public static ListNode getMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //快慢指针
        ListNode slow=head,fast = head;
        //快2步，慢1步，当快指针到末尾的时候，慢指针到中间
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 判断单向链表是否有环
     * @param head 链表
     * @return true有环，false无环
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow=head, fast=head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 快慢指针，两指针相遇则有环。
            // 如果有环，且环长是n，则会循环n次。（因为快指针每次比慢指针多走一步，从进入环开始，快指针需要把把环转一圈才能追上慢指针）
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

}
