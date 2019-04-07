package com.lxy.test.t400;

import org.junit.Test;

import java.util.Arrays;

/**
 * 找最小加热半径
 *
 * @author liuxinyun
 * @date 2019/4/7 16:12
 */
public class T0475FindRadius {

    @Test
    public void test() {
        int[] houses = {1, 2, 3};
        int[] headters = {2};
        System.out.println(power(houses, headters));
        int[] houses1 = {1, 2, 3, 4};
        int[] headters1 = {1, 4};
        System.out.println(power(houses1, headters1));

    }

    // 暴力破解，有些用例会超时
    public int power(int[] houses, int[] heaters) {
        int res = 0;
        for (int house : houses) {
            int max = Integer.MAX_VALUE;
            for (int heater : heaters) {
                max = Math.min(max, Math.abs(house - heater));
            }
            res = Math.max(res, max);
        }
        return res;
    }

    // 分情况讨论
    public int findRadius(int[] houses, int[] heaters) {
        // 先进行升序排列
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int housesLength = houses.length, heatersLength  = heaters.length;
        // 当前供暖器的下标
        int i = 0;
        int radius = 0;
        // 扫描所有房屋，每次只会处理当前半径无法覆盖的房屋
        for (int j = 0; j < housesLength; j++) {
            if (houses[j] < heaters[i] - radius) {
                // a. 房屋出现在供暖器的左侧，且当前半径无法覆盖，直接更新半径
                radius = heaters[i] - houses[j];
            }else if (houses[j] > heaters[i] + radius) {
                // b. 房屋出现在供暖器的右侧，且，当前半径无法覆盖，分两种情况
                // 1. 已经是最后一个供暖器，直接更新到最后一个房屋的半径，并结束
                if (i == heatersLength-1) {
                    radius = houses[housesLength-1] - heaters[i];
                    break;
                }
                // 2. 因为不是最后一个供暖器，那么房屋处在两个供暖器的中间
                if (heaters[i+1] <= houses[j]) {
                    // 2.1 此时下一个供暖器离当前房屋更近，更新供暖器下标，但是当前房屋还未得到处理，需重新处理
                    i++;
                    j--;
                    continue;
                }
                if (heaters[i+1] - radius <= houses[j]) {
                    // 2.2 下一个供暖器在当前半径下能覆盖到当前房屋，直接更新供暖器下标
                    i++;
                }else if (heaters[i+1] - houses[j] <= houses[j] -heaters[i]) {
                    // 2.3 下一个供暖器供暖当前房屋的半径小于当前供暖器供暖所需要的半径
                    radius = heaters[i+1] - houses[j];
                    i++;
                }else {
                    radius = houses[j] - heaters[i];
                }
            }
        }
        return radius;
    }

    // 根据分情况讨论进行优化
    public int findRadiusFixed(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int radius = 0;
        int i = 0;
        for (int house : houses) {
            while (i < heaters.length && heaters[i] < house) {
                // 一直找到处于房屋右侧的热水器
                i++;
            }
            if (i == 0)
                radius = Math.max(radius, heaters[i] - house);
            else if (i == heaters.length)
                // 最后一个热水器
                return Math.max(radius, houses[houses.length-1] - heaters[heaters.length-1]);
            else
                // 房屋右侧的热水器和房屋左侧的热水器，取小的那个
                radius = Math.max(radius, Math.min(heaters[i] - house, house - heaters[i - 1]));
        }
        return radius;
    }

}
