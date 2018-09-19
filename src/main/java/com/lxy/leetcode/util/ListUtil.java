package com.lxy.leetcode.util;

import com.lxy.leetcode.common.ListNode;

/**
 * @author liuxinyun
 * @date 2018/9/19 22:47
 */
public class ListUtil {

    public static void printList(ListNode ln) {
        while (true){
            System.out.print(ln.getVal());
            ln = ln.getNext();
            if (ln == null) {
                break;
            }
            System.out.print("->");
        }
    }

    public static ListNode convert(ListNode ln) {
        if (ln == null) {
            return null;
        }
        ListNode result = new ListNode(ln.getVal());
        ListNode temp;
        while (true){
            ln = ln.getNext();
            if (ln == null) {
                break;
            }
            temp = new ListNode(ln.getVal());
            temp.setNext(result);
            result = temp;
        }
        return result;
    }
}
