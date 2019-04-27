package com.lxy.test.my;

import com.lxy.leetcode.common.ListNode;
import com.lxy.leetcode.util.ListUtil;
import org.junit.Test;

import java.util.Scanner;

/**
 * @author liuxinyun
 * @date 2019/4/21 22:06
 */
public class MyTest {


    @Test
    public void test() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (scanner.hasNext()) {
                String nextLine = scanner.nextLine();
                String next = scanner.next();
                int nextInt = scanner.nextInt();
                long nextLong = scanner.nextLong();
            }
        }
    }

    @Test
    public void testListRemove() {
        ListNode head = new ListNode(1).of(2).of(3).of(4).of(2);
        //ListUtil.printList(ListUtil.remove(head, 2));
        ListNode head1 = new ListNode(1);
        ListUtil.printList(ListUtil.remove(head1, 1));
    }
}
