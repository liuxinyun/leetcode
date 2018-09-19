package com.lxy.leetcode.common;

/**
 * @author liuxinyun
 * @date 2018/9/19 21:43
 */
public class ListNode {

    private int val;

    private ListNode next;

    public ListNode(int x) {
        this.val = x;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
