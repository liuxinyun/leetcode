package com.lxy.test.t300;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 找到给定字符串中的最长子串T，要求T中的每一字符出现次数都不少于k。
 *
 * @author liuxinyun
 * @date 2019/4/8 22:15
 */
public class T0395LongestSubString {

    @Test
    public void test() {
        System.out.println(longestSubstring("baaabcb", 3));
    }

    public int longestSubstring(String s, int k) {
        int length = s.length();
        if (k < 1 || length < k)
            return 0;
        if (k == 1)
            return length;
        Map<Character, Integer> map  = new HashMap<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int small = 0;
        for (Integer value : map.values()) {
            if (value < k)
                small++;
        }
        if (small == 0)
            return length;
        int left = 0;
        int max = 0;
        int right  = 0;
        while (right < length) {
            char c = s.charAt(right);
            if (map.get(c) < k) {
                if (left < right)
                    max = Math.max(max, longestSubstring(s.substring(left, right), k));
                left = right + 1;
            }
            right++;
        }
        if (left <= length - k)
            max = Math.max(max, longestSubstring(s.substring(left), k));
        return max;
    }

}
