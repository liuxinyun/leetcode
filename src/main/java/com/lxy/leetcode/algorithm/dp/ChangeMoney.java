package com.lxy.leetcode.algorithm.dp;

/**
 * 动态规划找零钱
 * 有数组penny，penny中所有的值都为正数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张。
 * 再给定一个整数aim代表要找的钱数，求换钱有多少种方法。
 *
 * @作者：刘新运
 * @日期：2017/5/17 20:55
 * @描述：类
 */

public class ChangeMoney {

    /**
     * 所用的最少硬币个数
     * @param a
     * @param des
     * @return
     */
    public static int leastWay(int[] a, int des){
        if (a == null || a.length==0 || des<=0)
            return 0;
        //dp[n]表示组成n所使用的最少硬币数
        int[] dp = new int[des+1];
        for (int i=1; i<=des; i++){
            if (a[0]<=1)
                dp[i] = dp[i-a[0]]+1;
            for (int j=1; j<a.length; j++){
                if (a[j]<=i)
                    dp[i] =  dp[i]<(dp[i-a[j]]+1) ? dp[i] : dp[i-a[j]]+1;
            }
        }
        return dp[des];
    }

    /**
     * 凑成该数所有的可能
     * @param a
     * @param des
     * @return
     */
    public static int countWays(int[] a, int des){
        if (a == null || a.length==0 || des<=0)
            return 0;
        //dp[n][m]表示使用数组前n个数凑成m的方式
        int[][] dp = new int[a.length][des+1];
        dp[0][0] = 1;
        for (int i=1; a[0]*i<=des; i++)
            dp[0][a[0]*i] = 1;
        for (int i=1; i<a.length; i++){
            dp[i][0] = 1;
            for (int j=1; j<=des; j++){
                if (a[i]>j)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j]+dp[i-1][j-a[i]];
            }
        }
        return dp[a.length-1][des];
    }

    public static void main(String[] args) {
        int[] a = {1,2,4};
        int des = 4;
        System.out.println(countWays(a,des));
        System.out.println(leastWay(a,des));
    }
}
