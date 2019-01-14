package com.lxy.test.niuke;

import com.lxy.leetcode.common.ListNode;
import com.lxy.leetcode.util.ListUtil;
import org.junit.Test;

/**
 * 判断链表中有环
 *
 * @author liuxinyun
 * @date 2019/1/13 22:04
 */
public class ListNodeCycle {

    @Test
    public void test() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;
        boolean hasCycle = ListUtil.hasCycle(l1);
        System.out.println(hasCycle);
        //ListUtil.printList(detectCycle(l1));
    }

    /**
     * 如果有环找出入环位置
     */
    private ListNode detectCycle(ListNode head) {
        ListNode slow=head, fast=head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 快慢指针，两指针相遇则有环。
            // 如果有环，且环长是n，则会循环n次。（因为快指针每次比慢指针多走一步，从进入环开始，快指针需要把把环转一圈才能追上慢指针）
            if (slow == fast) {
                // 如果有环，将两指针分别放在链表头(X)和相遇位置(Z)，并改为相同速度推进，则两指针在环开始位置相遇(Y)。
                // 2(a+b) = a+b+n*(b+c)>>>a=(n-1)(b+c)+c，b+c是环的长度
                fast = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

}
