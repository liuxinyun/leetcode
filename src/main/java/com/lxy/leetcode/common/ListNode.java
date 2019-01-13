package com.lxy.leetcode.common;

/**
 * @author liuxinyun
 * @date 2018/9/19 21:43
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int x) {
        this.val = x;
        this.next = null;
    }

    public ListNode of(int val) {
        ListNode temp = this;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new ListNode(val);
        return this;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
