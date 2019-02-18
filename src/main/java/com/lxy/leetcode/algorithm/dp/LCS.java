package com.lxy.leetcode.algorithm.dp;

/**
 * 动态规划求最长公共子序列
 *
 * @作者：刘新运
 * @日期：2017/5/17 23:04
 * @描述：类
 */

public class LCS {

    /**
     * 返回最长公共子序列
     * @param s1
     * @param s2
     * @return
     */
    public static String getLCS(String s1, String s2){
        StringBuilder sb = new StringBuilder();//存储最长公共子序列
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        int[][] dp = new int[c1.length+1][c2.length+1];

        //从后向前
        for (int i=c1.length-1; i>=0; i--){
            for (int j=c2.length-1; j>=0; j--){
                if (c1[i] == c2[j])
                    dp[i][j] = dp[i+1][j+1] + 1;
                else
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
            }
        }
        int i=0, j=0;
        while (i<c1.length && j<c2.length){
            if (c1[i] == c2[j]){
                sb.append(c1[i]);
                i++;
                j++;
            }else{
                if (dp[i+1][j] >= dp[i][j+1])
                    i++;
                else
                    j++;
            }
        }
        return sb.toString();
    }

    /**
     * 返回最长公共子序列的数
     * @param s1
     * @param s2
     * @return
     */
    public static int getLCSCount(String s1, String s2){
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        int[][] dp = new int[c1.length][c2.length];
        //第一列赋初值
        for (int i=0; i<c1.length; i++){
            if (c1[i] == c2[0]){
                for (int j=i; j<c1.length; j++)
                    dp[j][0] = 1;
                break;
            }
        }
        //第一行赋初值
        for (int i=1; i<c2.length; i++){
            if (c1[0] == c2[i]){
                for (int j=i; j<c2.length; j++)
                    dp[0][j] = 1;
                break;
            }
        }

        //从前向后
        for (int i=1; i<c1.length; i++){
            for (int j=1; j<c2.length; j++){
                if (c1[i] == c2[j])
                    dp[i][j] = Math.max(dp[i-1][j-1]+1, Math.max(dp[i-1][j],dp[i][j-1]));
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

        return dp[c1.length-1][c2.length-1];
    }

    /**
     * 最长公共子串
     * @param s1
     * @param s2
     * @return
     */
    public static String getLCSStr(String s1, String s2){
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int[][] dp = new int[c1.length+1][c2.length+1];
        int max=0, x=0, y=0;//存储最大时的位置
        for (int i=1; i<=c1.length; i++){
            for (int j=1; j<=c2.length; j++){
                if (c1[i-1] == c2[j-1])
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = 0;
                if (dp[i][j] > max){
                    max = dp[i][j];
                    x=i;
                    y=j;
                }
            }
        }
        //输出最长公共子串
        StringBuilder sb = new StringBuilder();
        int i=x-1, j=y-1;
        while (i>=0 && j>=0){
            if (c1[i] == c2[j]){
                sb.append(c1[i]);
                i--;
                j--;
            }else {
                break;
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(getLCS("a1mnbc3","1a1wbz2c123a1b2c123"));
        System.out.println(getLCSCount("a1mnbc3","1a1wbz2c123a1b2c123"));
        System.out.println(getLCSStr("a1mnbc3","1a1wbz2c123a1b2c123"));
    }

}
