package com.lxy.test.t100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 获取杨辉三角的指定行
 * 直接使用组合公式C(n,i) = n!/(i!*(n-i)!)
 * 则第(i+1)项是第i项的倍数=(n-i)/(i+1);
 *
 * @author liuxinyun
 * @date 2019/4/10 23:12
 */
public class T0119TriangleII {

    @Test
    public void test() {
        System.out.println(getRow(4));
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        long cur = 1;
        for (int i = 0; i <= rowIndex; i++) {
            res.add((int) cur);
            cur = cur * (rowIndex-i)/(i+1);
        }
        return res;
    }

}
