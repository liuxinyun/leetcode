package com.lxy.test.t900;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 一手顺子牌
 *
 * @author liuxinyun
 * @date 2019/4/5 13:11
 */
public class T0846StraightHand {

    @Test
    public void test() {
        int[] hand = {1,2,2,3,3,3,4,4,5};
        System.out.println(isNStraightHand(hand, 3));
        int[] hand1 = {1,1,2,2,3,3};
        System.out.println(isNStraightHand(hand1, 3));
    }

    /**
     * 优化版本，根据顺子特征进行判断
     */
    public boolean fix(int[] hand, int w) {
        if(hand.length % w != 0)
            return false;
        int[] array = new int[w];
        for (int i : hand) {
            array[i % w]++;
        }
        for(int i = 0; i < w - 1; i++) {
            //若是顺子，array的每一元素理应是相等的
            if(array[i] != array[i+1])
                return false;
        }
        return true;
    }

    /**
     * 直接使用map，如果最小值和最大值差距很大，性能有很大问题
     */
    public boolean isNStraightHand(int[] hand, int w) {
        if (hand.length % w != 0) return false;
        Map<Integer, Integer> map = new HashMap<>(hand.length);
        List<Integer> keys = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i : hand) {
            min = i < min ? i : min;
            max = i > max ? i : max;
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }else {
                map.put(i, 1);
            }
        }
        while (min <= (max - w + 1)) {
            if (map.containsKey(min)) {
                int temp = map.get(min);
                map.remove(min);
                for (int i = 1; i < w; i++) {
                    if (!map.containsKey(min+i)) return false;
                    int sub = map.get(min+i) - temp;
                    if (sub < 0) return false;
                    if (sub > 0) map.put(min+i, sub);
                    if (sub == 0) map.remove(min+i);
                }
            }
            min++;
        }
        return map.isEmpty();
    }

}
