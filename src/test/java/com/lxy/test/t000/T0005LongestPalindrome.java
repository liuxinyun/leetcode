package com.lxy.test.t000;

import org.junit.Test;

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


    @Test
    public void test() {
        System.out.println(longestPalindromeDanymic("abaabac"));
        System.out.println(longestPalindromeMid("abaabac"));
    }

    // 动态规划求解：时间O(n^2)，空间O(n^2)
    public String longestPalindromeDanymic(String s) {
        if (s==null || s.length()<2) {
            return s;
        }

        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        // 单个字符必是回文串
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        // 相邻两个字母相等是回文串
        String longestSub = s.substring(0, 1);
        for (int i = 0; i < length-1; i++) {
            dp[i][i+1] = s.charAt(i) == s.charAt(i+1);
            if (dp[i][i+1]) {
                longestSub = s.substring(i, i+2);
            }
        }
        // 求长度大于2的回文串
        int maxLen = 0;
        for (int len = 3; len <= length; len++) {
            for (int i = 0; i <= length-len; i++) {
                int j = i + len - 1;
                dp[i][j] = dp[i+1][j-1] && s.charAt(i)==s.charAt(j);
                if (dp[i][j] && len > longestSub.length()) {
                    longestSub = s.substring(i, j + 1);
                }
            }
        }

        return longestSub;
    }

    // 给定整个字符串，和某个可能的中心位置，往外扩展
    public static String getEvery(String s, int i, int j) {
        while (i >=0 && j<=s.length()-1 && s.charAt(i)==s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i+1, j);
    }
    // 中心扩展法，本方法时间复杂度O(n^2)，但空间复杂度小，O(1)
    public static String longestPalindromeMid(String s) {
        if (s==null || s.length() < 2) {
            return s;
        }
        String sub = "";
        String temp;
        // 遍历每个可能的中心点，奇数回文串是在元素上，偶数是在元素间，所以共有（2n-1）种可能
        for (int i = 0; i < s.length(); i++) {
            temp = getEvery(s, i, i);
            if (temp.length() > sub.length()) {
                sub = temp;
            }
            temp = getEvery(s, i, i+1);
            if (temp.length() > sub.length()) {
                sub = temp;
            }
        }
        return sub;
    }


    public static char[] manacherString(String str){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append("#");
            sb.append(str.charAt(i));
        }
        sb.append("#");
        return sb.toString().toCharArray();
    }
    // 马拉车算法：时间复杂度O(n)
    public static int manacher(String str){
        if(str == null || str.length() < 1){
            return 0;
        }
        char[] charArr = manacherString(str);
        int[] radius = new int[charArr.length];
        int R = -1;
        int c = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < radius.length; i++) {
            radius[i] = R > i ? Math.min(radius[2*c-i],R-i+1):1;
            while(i+radius[i] < charArr.length && i - radius[i] > -1){
                if(charArr[i-radius[i]] == charArr[i+radius[i]]){
                    radius[i]++;
                }else{
                    break;
                }
            }
            if(i + radius[i] > R){
                R = i + radius[i]-1;
                c = i;
            }
            max = Math.max(max,radius[i]);
        }
        return max-1;
    }

}
