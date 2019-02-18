package com.lxy.leetcode.algorithm.find;

import com.lxy.leetcode.common.ZuoBiao;

import java.util.*;

/**
 * 使用BFS和DFS分别实现从坐标（0，0）每次只能跳对角点，遍历从-5到5的正方形区域
 * 其中有些坐标不能选择
 * 对比输出结果可发现，BFS是一层层往外搜索，DFS是沿一个方向往外搜。
 *
 */

public class FirstSearch {

    private static final int[] D = {-1,1};

    public static void main(String[] args) {
        bfs();
        System.out.println();
        dfs();
    }

    public static void bfs(){
        Set<ZuoBiao> disable = new HashSet<>();//存储禁止跳转的点
        Set<ZuoBiao> finish = new HashSet<>();//存储已经跳过的点
        ZuoBiao start = new ZuoBiao(0, 0);
        finish.add(start);

        Queue<ZuoBiao> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()){
            ZuoBiao temp = queue.poll();
            for (int i : D) {
                for (int j : D) {
                    ZuoBiao next = new ZuoBiao(temp.getX() + i, temp.getY() + j);
                    if (Math.abs(next.getX()) > 5 || Math.abs(next.getY()) > 5) {
                        continue;
                    }
                    if (finish.contains(next) || disable.contains(next)) {
                        continue;
                    }
                    queue.add(next);//放入队列
                    finish.add(next);//放入已跳转集合
                    System.out.print("(" + next.getX() + "," + next.getY() + ")");
                }
            }
        }
    }

    public static void dfs(){
        Set<ZuoBiao> disable = new HashSet<>();//存储禁止跳转的点
        Set<ZuoBiao> finish = new HashSet<>();//存储已经跳过的点
        ZuoBiao start = new ZuoBiao(0, 0);
        finish.add(start);

        Stack<ZuoBiao> stack = new Stack<>();
        stack.push(start);
        while (!stack.isEmpty()){
            ZuoBiao temp = stack.pop();
            for (int i : D) {
                for (int j : D) {
                    ZuoBiao next = new ZuoBiao(temp.getX() + i, temp.getY() + j);
                    if (Math.abs(next.getX()) > 5 || Math.abs(next.getY()) > 5) {
                        continue;
                    }
                    if (finish.contains(next) || disable.contains(next)) {
                        continue;
                    }
                    stack.push(next);//入栈
                    finish.add(next);//放入已跳转集合
                    System.out.print("(" + next.getX() + "," + next.getY() + ")");
                }
            }
        }
    }

}
