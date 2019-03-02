package com.lxy.leetcode.algorithm.dp;

/**
 * 动态规划求最短路径
 * 有一个矩阵map，它每个格子有一个权值。
 * 从左上角的格子开始每次只能向右或者向下走，最后到达右下角的位置。
 * 路径上所有的数字累加起来就是路径和，返回所有的路径中最小的路径和。
 *
 * @作者：刘新运
 * @日期：2017/5/17 22:01
 * @描述：类
 */

public class MinPath {

    public static int minPath (int[][] map, int r, int c){
        int[][] dp = new int[r][c];
        dp[0][0] = map[0][0];
        for (int i=1; i<r; i++) {
            dp[i][0] = dp[i-1][0] + map[i][0];
        }
        for (int j=1; j<c; j++) {
            dp[0][j] = dp[0][j-1] + map[0][j];
        }
        for (int i=1; i<r; i++){
            for (int j=1; j<c; j++){
                dp[i][j] = dp[i][j-1]<dp[i-1][j] ? (dp[i][j-1]+map[i][j]) : (dp[i-1][j]+map[i][j]);
            }
        }
        return dp[r-1][c-1];
    }

    public static void main(String[] args) {
        int[][] a = {
                {1,2,3},
                {1,1,1}
        };
        int r = 2;
        int c = 3;
        System.out.println(minPath(a,r,c));
    }
}
