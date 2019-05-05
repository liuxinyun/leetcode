package com.lxy.test.my;

import org.junit.Test;

/**
 * 找符合条件的数，和为指定值
 *
 * @author liuxinyun
 * @date 2019/5/5 22:57
 */
public class FindNumberWithSum {

    @Test
    public void test1() {
        int[] data = {1, 2, 3, 7, 11, 20};
        System.out.println(findNumberWithSum(data, 27));
    }

    /**
     * 从递增数组中找两个数，使他们的和为sum，找到一组即可
     *
     * @param data
     * @param sum
     * @return
     */
    public static boolean findNumberWithSum(int[] data, int sum) {
        if (data.length < 2) {
            return false;
        }
        int low = 0;
        int high = data.length-1;
        while (low < high) {
            long curSum = data[low] + data[high];
            if (curSum == sum) {
                System.out.println("success，two num：" + data[low] + "," + data[high]);
                return true;
            }
            if (curSum > sum) {
                high--;
            }else {
                low++;
            }
        }
        return false;
    }

    @Test
    public void test2() {
        findSeriousSequence(100);
    }

    /**
     * 找连续数字等于sum
     *
     * @param sum
     */
    public static void findSeriousSequence(int sum) {
       if (sum < 3) {
           return;
       }
       int small = 1;
       int big = 2;
       int middle = (sum + 1) >> 1;
       int curSum = small + big;
       while (small < middle) {
           if (curSum == sum) {
               printContinuousSequence(small, big);
           }
           while (curSum > sum && small < middle) {
               curSum -= small;
               small++;
               if (curSum == sum) {
                   printContinuousSequence(small, big);
               }
           }
           big++;
           curSum += big;
       }
    }

    /**
     * 输出从数small到big之间的所有数
     * @param small 开始数【包含】
     * @param big  结束数【包含】
     */
    public static void printContinuousSequence(int small,int big) {
        for(int i = small ; i < big ; i++)
        {
            System.out.print(i + ",");
        }
        System.out.println(big);
    }

}
