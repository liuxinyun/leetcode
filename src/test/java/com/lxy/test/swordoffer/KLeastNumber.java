package com.lxy.test.swordoffer;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 剑指offer40：最小的k个数
 *
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 *
 * @author liuxinyun
 * @date 2021/6/13 18:07
 */
public class KLeastNumber {

    public static void main(String[] args) {
        int[] arr = {0,0,1,2,4,2,2,3,1,4};
        System.out.println(Arrays.toString(getLeastNumbers(arr, 8)));
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0){
            return new int[0];
        }
        // 默认从小往大，即小根堆。本题求前k小，需要使用大根堆，重写排序
        Queue<Integer> queue = new PriorityQueue<>(k, (v1, v2) -> v2 - v1);
        for (int num : arr) {
            if (queue.size() < k) {
                queue.offer(num);
            }else if (num < queue.peek()) {
                queue.poll();
                queue.offer(num);
            }
        }
        // 返回堆中元素
        int[] res = new int[k];
        int i = 0;
        for (Integer num : queue) {
            res[i++] = num;
        }
        return res;
    }

}
