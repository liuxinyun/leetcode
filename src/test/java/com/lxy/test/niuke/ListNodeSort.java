package com.lxy.test.niuke;

import com.lxy.leetcode.common.ListNode;
import com.lxy.leetcode.util.ListUtil;
import org.junit.Test;

/**
 * @author liuxinyun
 * @date 2019/1/12 18:01
 */
public class ListNodeSort {

    @Test
    public void test() {
        ListNode listNode = new ListNode(2).of(5).of(3).of(6).of(4);
        ListNode result = insertSortList(listNode);
        ListUtil.printList(result);
    }

    private ListNode insertSortList(ListNode head) {
        if (head==null || head.next==null)
            return head;

        ListNode pre = head;//pre指向已经有序的节点
        ListNode cur = head.next;//cur指向待排序的节点

        ListNode aux = new ListNode(-1);//辅助节点
        aux.next = head;

        while(cur!=null){
            if(cur.val<pre.val){
                //先把cur节点从当前链表中删除，然后再把cur节点插入到合适位置
                pre.next = cur.next;

                //从前往后找到l2.val>cur.val,然后把cur节点插入到l1和l2之间
                ListNode l1 = aux;
                ListNode l2 = aux.next;
                while(cur.val>l2.val){
                    l1 = l2;
                    l2 = l2.next;
                }
                //把cur节点插入到l1和l2之间
                l1.next = cur;
                cur.next = l2;//插入合适位置

                cur = pre.next;//指向下一个待处理节点

            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        return aux.next;
    }

    /**
     * 采用归并排序
     */
    private ListNode sortList(ListNode head) {
        if (head==null || head.next==null)
            return head;
        // 获取中间节点
        ListNode mid = getMid(head);
        ListNode right = mid.next;
        mid.next = null;
        return merge(sortList(head), sortList(right));
    }

    /**
     * 合并两个链表为一个
     */
    private ListNode merge(ListNode left, ListNode right) {
        ListNode p1 = left, p2 = right, result;
        // 得到头节点
        if (p1.val < p2.val) {
            result = p1;
            p1 = p1.next;
        }else {
            result = p2;
            p2 = p2.next;
        }

        // 依次合并两个链表中的值
        ListNode p = result;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                p.next = p1;
                p1 = p1.next;
            }else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }

        // 将p1中剩余的补充上
        if (p1 != null) {
            p.next = p1;
        }
        // 将p2中剩余的补充上
        if (p2 != null) {
            p.next = p2;
        }

        return result;
    }

    /**
     * 获取中间节点
     */
    private ListNode getMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //快慢指针
        ListNode slow = head, quick = head;
        //快2步，慢1步，当快指针到末尾的时候，慢指针到中间
        while (quick.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }


}
