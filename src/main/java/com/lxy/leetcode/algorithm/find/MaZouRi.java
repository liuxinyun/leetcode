package com.lxy.leetcode.algorithm.find;

import com.lxy.leetcode.common.ZuoBiao;

import java.util.*;

/**
 * 本例是使用BFS进行求解坐标上只能走“日”字形的点，求两点之间最小距离
 *
 */
public class MaZouRi {

    private static final int[] D = {-2,-1,1,2};

    public static void main(String[] args) {
        Map<ZuoBiao, ZuoBiao> map = new HashMap<>();//存储已经跳跃的点
        ZuoBiao start = new ZuoBiao(0,0);
        ZuoBiao end  = new ZuoBiao(3,2);
        Set<ZuoBiao> disable = new HashSet<>();//存储禁止跳跃的点
        for (int i : D) {
            for (int j : D) {
                if (i == 1 && j == 2) {
                    continue;//其它屏蔽，只开右上角
                }
                if (Math.pow(i, 2) + Math.pow(j, 2) == 5) {
                    ZuoBiao zb = new ZuoBiao(end.getX() + i, end.getY() + j);
                    disable.add(zb);
                }
            }
        }

        Queue<ZuoBiao> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()){
            ZuoBiao temp = queue.poll();
            if (end.equals(temp)){
                break;
            }
            for (int i : D) {
                for (int j : D) {
                    if (Math.pow(i, 2) + Math.pow(j, 2) == 5) {
                        ZuoBiao zb = new ZuoBiao(temp.getX() + i, temp.getY() + j);
                        if (disable.contains(zb) || map.containsKey(zb)) {
                            continue;
                        }
                        map.put(zb, temp);
                        queue.add(zb);
                    }
                }
            }
        }
        //倒叙输出最短路径经过的点
        while (!start.equals(end)){
            System.out.print("("+end.getX()+","+end.getY()+"),");
            end = map.get(end);
        }
        System.out.println("("+end.getX()+","+end.getY()+")");
    }

}
