package com.lxy.test.t800;

import com.lxy.leetcode.common.ListNode;
import com.lxy.leetcode.util.ListUtil;
import org.junit.Test;

/**
 * @author liuxinyun
 * @date 2019/5/12 20:22
 */
public class T0876ListMiddleNode {

    @Test
    public void test() {
        ListNode node = new ListNode(1).of(2).of(3).of(4).of(5);
        ListUtil.printList(middleNode(node));
    }

    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //快慢指针
        ListNode slow=head, fast = head;
        //快2步，慢1步，当快指针到末尾的时候，慢指针到中间
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return fast.next==null ? slow : slow.next;
    }

}
