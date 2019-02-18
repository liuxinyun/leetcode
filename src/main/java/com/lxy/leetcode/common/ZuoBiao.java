package com.lxy.leetcode.common;

/**
 * @author liuxinyun
 * @date 2018/12/11 22:40
 */
public class ZuoBiao {
    private int x;
    private int y;

    public ZuoBiao() {
    }

    public ZuoBiao(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "ZuoBiao{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ZuoBiao zuoBiao = (ZuoBiao) o;

        return x == zuoBiao.x && y == zuoBiao.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
