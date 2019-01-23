package com.lxy.test.niuke;

import com.lxy.leetcode.common.ListNode;
import com.lxy.leetcode.util.ListUtil;
import org.junit.Test;

/**
 * @author liuxinyun
 * @date 2019/1/23 23:11
 */
public class ListNodeAddTwoNum {

    @Test
    public void test() {
        ListNode l1 = new ListNode(2).of(4).of(9);
        ListNode l2 = new ListNode(5).of(6);
        ListNode listNode = addTwoNumbers(l1, l2);
        ListUtil.printList(listNode);
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        int sum = 0;
        int carry = 0;
        ListNode temp = result;
        while (l1!=null || l2!=null) {
            int v1 = 0;
            int v2 = 0;
            if (l1!=null) {
                v1 = l1.val;
                l1 = l1.next;
            }
            if (l2!=null) {
                v2 = l2.val;
                l2 = l2.next;
            }
            sum = v1 + v2 + carry;
            temp.next = new ListNode(sum%10);
            temp = temp.next;
            carry = sum/10;
        }
        if (carry > 0) {
            temp.next = new ListNode(carry);
        }
        return result.next;
    }

}
