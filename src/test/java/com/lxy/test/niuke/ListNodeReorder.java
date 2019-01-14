package com.lxy.test.niuke;

import com.lxy.leetcode.common.ListNode;
import com.lxy.leetcode.util.ListUtil;
import org.junit.Test;

import java.util.List;

/**
 * 单向链表重排序
 *  L0→Ln →L1→L(n-1)→L2→L(n-2)→…
 *
 * @author liuxinyun
 * @date 2019/1/14 22:55
 */
public class ListNodeReorder {

    @Test
    public void test() {
        ListNode listNode = new ListNode(2).of(5).of(3).of(6).of(4);
        reorderList(listNode);
        ListUtil.printList(listNode);
    }

    private void reorderList(ListNode head) {
        if(head==null || head.next==null)
            return;
        // 获取中间节点
        ListNode mid = ListUtil.getMid(head);
        ListNode right = mid.next;
        mid.next = null;

        // 反转右半边
        right = ListUtil.convert(right);

        // 合并左右
        ListNode l1 = head;
        ListNode l2 = right;
        while (l1!=null && l2!=null) {
            ListNode tmp1 = l1.next;
            ListNode tmp2 = l2.next;
            l1.next = l2;
            l2.next = tmp1;
            l1 = tmp1;
            l2 = tmp2;
        }
    }

}
