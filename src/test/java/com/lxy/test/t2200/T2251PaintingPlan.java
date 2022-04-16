package com.lxy.test.t2200;

import org.junit.Test;

/**
 * 画板上有 n * n 的网格。绘画规则为，小扣可以选择任意多行以及任意多列的格子涂成黑色（选择的整行、整列均需涂成黑色），所选行数、列数均可为 0。
 * 希望最终的成品上需要有 k 个黑色格子，请返回共有多少种涂色方案。
 * 注意：两个方案中任意一个相同位置的格子颜色不同，就视为不同的方案。
 *
 *
 * @author liuxinyun
 * @date 2022/4/9 16:23
 */
public class T2251PaintingPlan {

    @Test
    public void test(){
        System.out.println(paintingPlan(4, 12));
    }

    public int paintingPlan(int n, int k) {
        if (k == 0 || k == n * n) {
            return 1;
        }
        if (k < n) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (k == (i + j) * n - (i * j)) {
                    res += Cnm(n, i) * Cnm(n, j);
                }
            }
        }
        return res;
    }

    private int Cnm(int n, int m) {
        if (m == 0 || n == m) {
            return 1;
        }
        if (m == 1) {
            return n;
        }
        if (n < m) {
            return 0;
        }
        return Cnm(n - 1, m - 1) + Cnm(n - 1, m);
    }

}
