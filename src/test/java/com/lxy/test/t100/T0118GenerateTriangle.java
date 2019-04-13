package com.lxy.test.t100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 产生杨辉三角
 *
 * @author liuxinyun
 * @date 2019/4/10 22:48
 */
public class T0118GenerateTriangle {

    @Test
    public void test() {
        System.out.println(generate(5));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>(i);
            list.add(1);
            if (i > 0) {
                List<Integer> pre = lists.get(i - 1);
                for (int j = 1; j < i; j++) {
                    list.add(pre.get(j-1) + pre.get(j));
                }
                list.add(1);
            }
            lists.add(list);
        }
        return lists;
    }

}
