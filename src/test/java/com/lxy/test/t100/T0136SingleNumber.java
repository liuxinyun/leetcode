package com.lxy.test.t100;

import org.junit.Test;

/**
 * 只出现一次的数字
 *
 * version1: 找出一个数组中一个只出现一次的数字，其他数字都出现两次：将所有数字异或，得到的结果即为只出现一次的。
 * version2: 找出一个数组中两个只出现一次的数字，其他数字都出现两次：将所有数字异或，得到的结果即为x=a^b, index为x中第一个为1的位，则a 和b中第index为必然有一个为1，有一个为0。
 * 据此将所有数据分为两组，一组的第index为都为1，另一组第index为都为0，第一组数字异或得到a，第二组数字异或得到b。时间复杂度为o(n),空间复杂度为o(1)。
 * （判断某一位是否为1：int result=a&(1<<i)）若结果不为0，则a的第i位为1；否则第i位为1。
 *
 * version3:找出一个数组中三个只出现一次的数字，其他数字都出现两次：将所有数字异或，得到的结果为x=a^b^c。x必然与a,b,c都不相同，因此x^a,x^b,x^c都不为0.
 * 定义函数f(n)，作用是保留数字n的二进制表示中最后一位1，而其他位都变为0. 则f(x^a),f(x^b),f(x^c)的结果均不为0.
 * 考虑f(x^a)^f(x^b)^f(x^c)的结果，它肯定不为0。因为对于三个非零的数i,j,k, f(i)^f(j)的结果要么为0，要么结果的二进制结果中有两个是1，而f(k)的结果中只有一位是1，所以f(i)^f(j)^f(k)一定不为0。
 * 因此f(x^a)^f(x^b)^f(x^c)至少有一位为1，假设最后一位是1的位为第 m 位。那么x^a, x^b, x^c的结果中，有一个或者三个数字的第m位是1.
 * 下面证明不可能三个结果的第m位都是1. 反证法证明：若x^a，x^b， x^c的第m位都是1，则a,b,c的第m位都和x的第m位相反，那么a,b,c的第m位相同。
 * 若都为0，则x=a^b^c的第m为也未0，与x的第m位与a,b,c第m位相反矛盾；同样若都为1，则x第m位为1，与假设矛盾。因此a,b,c中只有一个数字的第m位为1。
 * 于是我们找到了区分a,b,c三个数字的标准。一旦将第m位为1的数找出来之后，另外两个数字也可以找出来了。
 *
 * version4: 一个数组中除了一个数字出现一次外，其他数字都出现了三次，找出只出现了一次的数字。
 * 思路：若数组中没有x，则其他所有数字都出现了三次，那么所有数字的二进制表示的每一位相加都应该可以被3整除，如果某一位不能，则表明x在这一位上是1。
 * 这种解决方案可以扩展到其他所有数字都出现了N次的情形。
 *
 * @author liuxinyun
 * @date 2019/4/18 23:09
 */
public class T0136SingleNumber {

    @Test
    public void test() {
        System.out.println(f(6));
        int[] nums = {1, 2, 2};
        System.out.println(singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        int num = 0;
        for (int i : nums) {
            num ^= i;
        }
        return num;
    }

    /**
     * num的最后一位1在倒数第几位
     *
     * @param num 待判断数字
     * @return 最后一位1的倒数位置
     */
    public static int f(int num) {
        return num & (-num);
    }

    /**
     * a的二进制第i位是不是1
     *
     * @param a 数字
     * @param i 位数
     * @return true：是
     */
    public static boolean isBit1(int a, int i) {
        return ((a>>i)&1) == 1;
    }

}
