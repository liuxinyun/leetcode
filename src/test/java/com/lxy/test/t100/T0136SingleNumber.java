package com.lxy.test.t100;

import org.junit.Test;

import java.util.Arrays;

/**
 * 只出现一次的数字
 *
 * version1: 找出一个数组中一个只出现一次的数字，其他数字都出现两次：将所有数字异或，得到的结果即为只出现一次的。
 * version2: 找出一个数组中两个只出现一次的数字，其他数字都出现两次：将所有数字异或，得到的结果即为x=a^b, index为x中第一个为1的位，则a 和b中第index位必然有一个为1，有一个为0。
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
        int[] nums1 = {1, 2, 2, 3, 3};
        System.out.println(singleNumber1(nums1));
        int[] nums2 = {1, 2, 2, 3, 5, 3};
        System.out.println(Arrays.toString(singleNumber2(nums2)));
        int[] nums3 = {1, 2, 2, 3, 4, 3, 5};
        System.out.println(Arrays.toString(singleNumber3(nums3)));
        int[] nums4 = {1, 2, 2, 2, 3, 1, 1};
        System.out.println(singleNumber4(nums4, 3));
    }

    /**
     * 只要一个出现一次，其余出现两次
     * @param nums
     * @return
     */
    public int singleNumber1(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    /**
     * 有两个数字出现一次，其余的出现两次，找出这两个数字
     * @param nums
     */
    public int[] singleNumber2(int[] nums) {
        int temp = 0;
        for (int num : nums) {
            temp ^= num;
        }
        int index = lastBitPos(temp);
        // 按index位为1和0进行分组
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if (isBit1(num, index)) {
                a ^= num;
            }else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }

    public int[] singleNumber3(int[] nums) {
        int temp = 0;
        for (int num : nums) {
            temp ^= num;
        }
        int flag = 0;
        for (int num : nums) {
            flag ^= f(temp ^ num);
        }
        int m = f(flag);
        // 获取第一个数
        int a = 0;
        for (int num : nums) {
            if (f(temp ^ num) == m) {
                a ^= num;
            }
        }
        // 将第一个数放在最后一位
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == a) {
                nums[i] = nums[nums.length-1];
                nums[nums.length-1] = a;
                break;
            }
        }
        // 现在对前边的数做查找2个出现1次的操作
        int[] nums1 = new int[nums.length-1];
        System.arraycopy(nums, 0, nums1, 0, nums1.length);
        int[] number2 = singleNumber2(nums1);
        int[] result = new int[3];
        result[0] = a;
        result[1] = number2[0];
        result[2] = number2[1];
        return result;
    }

    /**
     * 一个数字出现1次，其余数字出现n次，则其余数字二进制的每一位相加必为n的倍数。
     *
     * @param nums
     * @param n
     * @return
     */
    public int singleNumber4(int[] nums, int n) {
        int result = 0;
        for (int i=0; i<32; ++i) {
            int bits = 0;
            for (int num : nums) {
                bits += (num>>i) & 1;
            }
            result |= (bits % n) << i;
        }
        return result;
    }

    /**
     * 保留数字n的二进制表示中最后一位1，而其他位都变为0
     *
     * @param num 待判断数字
     * @return 转化后的数字
     */
    public static int f(int num) {
        // ~(num - 1) 等价于 -num
        return num & -num;
    }

    /**
     * 求最后一位1的位置
     *
     * @param num
     * @return
     */
    public static int lastBitPos(int num) {
        int i = 0;
        while (num % 2 == 0) {
            num = num >> 1;
            i++;
        }
        return i;
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
