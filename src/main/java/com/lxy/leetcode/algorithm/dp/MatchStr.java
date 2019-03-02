package com.lxy.leetcode.algorithm.dp;

/**
 * 动态规划字符串匹配
 * 带通配符*和?的字符串匹配
 * "*"可以匹配0个或0个以上字符
 * "?"可以匹配一个字符
 * leetcode44
 * 原文链接：http://www.mamicode.com/info-detail-986984.html
 *
 * @作者: liuxinyun
 * @日期: 2017/5/17 16:22
 * @描述:
 */
public class MatchStr {

    /**
     * 其中一个字符串包含通配符
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p){
        int countXing = 0;
        for(char c : p.toCharArray()) {
            if (c == '*') {
                countXing++;
            }
        }
        if(p.length() - countXing > s.length() ) {
            //说明p去掉通配符，长度也长于s
            return false;
        }

        //动态规划设置初值
        boolean[][] dp = new boolean[p.length()+1][s.length()+1];
        dp[0][0] = true;

        for(int i=1; i<=p.length(); i++) {
            char pChar = p.charAt(i-1);
            //设置每次循环的初值，即当星号不出现在首位时，匹配字符串的初值都为false
            dp[i][0] = dp[i-1][0] && pChar=='*';
            for(int j=1; j<=s.length(); j++) {
                char sChar = s.charAt(j-1);
                if(pChar == '*') {
                    //动态规划递推式（星号） 表示星号可以匹配0个（决定于上次外循环的结果）或者多个（决定于刚才内循环的结果）
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                } else {
                    //动态规划递推式（非星号） 表示dp值取决于上次的状态和当前状态
                    dp[i][j] = dp[i-1][j-1] && (pChar=='?' || sChar == pChar);
                }
            }
        }
        return dp[p.length()][s.length()];
    }

    /**
     * 两个字符串均包含通配符
     * @param s1
     * @param s2
     * @return
     */
    public static boolean isMatchByBoth(String s1, String s2) {

        //动态规划设置初值
        boolean[][] dp = new boolean[s2.length()+1][s1.length()+1];
        dp[0][0] = true;

        for(int i=1; i<=s2.length(); i++) {
            char s2Char = s2.charAt(i-1);
            //设置每次循环的初值，即当星号不出现在首位时，匹配字符串的初值都为false
            dp[i][0] = dp[i-1][0] && s2Char=='*';
            for(int j=1; j<=s1.length(); j++) {
                char s1Char = s1.charAt(j-1);
                dp[0][j] = dp[0][j-1] && s1.charAt(j-1)=='*';
                if(s2Char=='*' || s1Char=='*') {
                    //动态规划递推式（星号） 表示星号可以匹配0个（决定于上次外循环的结果）或者多个（决定于刚才内循环的结果）
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                } else {
                    dp[i][j] = dp[i-1][j-1] && (s1Char=='?' || s2Char=='?' || s1Char == s2Char);
                }
            }
        }
        return dp[s2.length()][s1.length()];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("a", "a***"));
        System.out.println(isMatchByBoth("*a*", "a*aa"));
    }
}
