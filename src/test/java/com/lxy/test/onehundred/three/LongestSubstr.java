package com.lxy.test.onehundred.three;

import org.junit.Test;

import java.util.HashMap;

/**
 * 最长子串长度
 *
 * @author liuxinyun
 * @date 2018/9/29 21:00
 */
public class LongestSubstr {

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring("abcacbde"));
    }

    private int lengthOfLongestSubstring(String s) {
        if (s==null || s.equals("")){
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }

}
