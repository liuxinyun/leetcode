package com.lxy.leetcode.util;

import com.lxy.leetcode.common.ListNode;

/**
 * @author liuxinyun
 * @date 2018/9/19 22:47
 */
public class ListUtil {

    public static void printList(ListNode ln) {
        ListNode cur = ln;
        while (cur != null){
            System.out.print(cur.val);
            if ((cur=cur.next) != null) {
                System.out.print("->");
            }
        }
    }

    public static ListNode convert(ListNode ln) {
        if (ln == null) {
            return null;
        }
        ListNode result = new ListNode(ln.val);
        ListNode temp;
        while ((ln = ln.next) != null){
            temp = new ListNode(ln.val);
            temp.next = result;
            result = temp;
        }
        return result;
    }
}
