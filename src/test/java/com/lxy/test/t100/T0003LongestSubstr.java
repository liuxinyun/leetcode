package com.lxy.test.t100;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 无重复字符的最长子串长度
 *
 * @author liuxinyun
 * @date 2018/9/29 21:00
 */
public class T0003LongestSubstr {

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstringBySet("abcacbde"));
    }


    /**
     * 滑窗法，时间复杂度O(2n)=O(n)，每次字符将被i和j访问两次。
     * @param s
     * @return
     */
    private int lengthOfLongestSubstringBySet(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * 优化后滑窗法，遍历一遍即可
     * [j,i)中有等于s(i)的，不需要逐渐增加j，则j直接跳过变为相等元素位置+1.
     *
     * @param s
     * @return
     */
    private int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); ++i) {
            char cur = s.charAt(i);
            if (map.containsKey(cur)) {
                j = Math.max(j, map.get(cur) + 1);
            }
            max = Math.max(max, i - j + 1);
            map.put(cur, i);
        }
        return max;
    }

}
