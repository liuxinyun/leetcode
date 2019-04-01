package com.lxy.test.t100;

/**
 * 最长回文子串
 * 1、倒转后求最长公共子串，有缺陷需修O(n^2)
 * 2、动态规划O(n^2)
 * 3、Manacher算法，O(n)，参考：https://www.jianshu.com/p/116aa58b7d81
 *
 * @author liuxinyun
 * @date 2019/3/31 22:49
 */
public class T0005LongestPalindrome {



    public String longestPalindrome(String s) {
        int length = s.length();
        int[][] dp = new int[length-1][length-1];

        return "";
    }
}
