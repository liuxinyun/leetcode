package com.lxy.test.onehundred.two;

import com.lxy.leetcode.common.ListNode;
import com.lxy.leetcode.util.ListUtil;
import org.junit.Test;

/**
 * 备注：因为定义实体使用了属性私有，通过公有方法设置值，所以在LeetCode上提交运行时需要将get，set替换
 *
 * @author liuxinyun
 * @date 2018/9/19 21:47
 */
public class TwoListSum {

    @Test
    public void test(){
        ListNode l1 = new ListNode(5);
        l1.setNext(new ListNode(9));
        ListNode l2 = new ListNode(5);
        ListNode listNode = addTwoNumbers(l1, l2);
        ListUtil.printList(listNode);
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result;
        int sum = l1.getVal() + l2.getVal();
        int d = 0;
        if (sum < 10){
            result = new ListNode(sum);
        }else {
            d = 1;
            result = new ListNode(sum % 10);
        }
        l1 = l1.getNext();
        l2 = l2.getNext();

        ListNode temp;
        while (d != 0 || l1 != null || l2!=null) {
            int v1 = (l1 == null) ? 0 : l1.getVal();
            int v2 = (l2 == null) ? 0 : l2.getVal();
            sum = v1 + v2 + d;
            if (sum < 10){
                d = 0;
                temp = new ListNode(sum);
            }else {
                d = 1;
                temp = new ListNode(sum % 10);
            }
            // 此处是反向排列，最终需要反转
            temp.setNext(result);
            result = temp;

            l1 = (l1 == null) ? null : l1.getNext();
            l2 = (l2 == null) ? null : l2.getNext();
        }

        return ListUtil.convert(result);
    }

}
