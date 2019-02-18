package com.lxy.leetcode.algorithm.dp;

/**
 * 动态规划上楼梯/斐波那契额数列
 * f(n)=f(n-1)+f(n-2)
 *
 * @作者：刘新运
 * @日期：2017/5/17 22:35
 * @描述：类
 */

public class UpStairs {

    public static int countWays(int n){
        if (n<=2)
            return n;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3; i<=n; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(countWays(8));
    }

}
