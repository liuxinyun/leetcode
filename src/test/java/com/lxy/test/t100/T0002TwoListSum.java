package com.lxy.test.t100;

import com.lxy.leetcode.common.ListNode;
import com.lxy.leetcode.util.ListUtil;
import org.junit.Test;

/**
 * @author liuxinyun
 * @date 2018/9/19 21:47
 */
public class T0002TwoListSum {

    @Test
    public void test(){
        ListNode l1 = new ListNode(5).of(9);
        ListNode l2 = new ListNode(5);
        ListNode listNode = addTwoNumbers(l1, l2);
        ListUtil.printList(listNode);
    }

    /**
     * 初始思路所想
     */
    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = l1.val + l2.val;
        int d = sum / 10;
        ListNode result = new ListNode(sum % 10);
        l1 = l1.next;
        l2 = l2.next;

        ListNode temp;
        while (d > 0 || l1 != null || l2!=null) {
            int v1 = (l1 == null) ? 0 : l1.val;
            int v2 = (l2 == null) ? 0 : l2.val;
            sum = v1 + v2 + d;
            d = sum / 10;
            temp = new ListNode(sum % 10);
            // 此处是反向排列，最终需要反转
            temp.next = result;
            result = temp;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return ListUtil.convert(result);
    }

    /**
     * 充分利用变量复制后的引用传递，不需要再反转
     */
    private ListNode fix(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            int x = (l1 == null) ? 0 : l1.val;
            int y = (l2 == null) ? 0 : l2.val;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return dummyHead.next;
    }

}
