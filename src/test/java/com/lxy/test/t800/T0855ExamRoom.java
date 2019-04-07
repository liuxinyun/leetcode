package com.lxy.test.t800;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuxinyun
 * @date 2019/4/5 19:29
 */
public class T0855ExamRoom {

    @Test
    public void test() {
        ExamRoom examRoom = new ExamRoom(10);
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        examRoom.leave(0);
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        examRoom.leave(4);
        System.out.println(examRoom.seat());
    }

    class ExamRoom {

        private int N;
        private List<Integer> list;

        public ExamRoom(int N) {
            this.N = N;
            this.list = new ArrayList<>();
        }

        public int seat() {
            if (list.isEmpty()) {
                list.add(0);
                return 0;
            }
            // 要坐的座位号
            int p = 0;
            // 最大距离，此处必须是第一个位置对应的值，表示到0的最大距离
            int max = list.get(0);
            // 计算相邻两考生间的距离，大于max更新
            for (int i = 0; i < list.size()-1; i++) {
                int a = list.get(i), b = list.get(i+1);
                if ((b-a)/2 > max) {
                    max = (b-a)/2;
                    p = a + max;
                }
            }
            if (N-1 - list.get(list.size()-1) > max) {
                p = N-1;
            }
            // 二分查找找到插入位置
            int low = 0, high = list.size();
            while (low < high) {
                int mid = low + (high-low)/2;
                if (p > list.get(mid)) {
                    low = mid + 1;
                }else {
                    high = mid;
                }
            }
            list.add(low, p);
            return p;
        }

        public void leave(int p) {
            // 此处必须是自己构造对象来移除，因为list有另一个方法是直接移除对应位置list.remove(int index);
            list.remove(new Integer(p));
        }
    }

}
