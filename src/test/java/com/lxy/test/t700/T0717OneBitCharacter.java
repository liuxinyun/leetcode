package com.lxy.test.t700;

/**
 * 1比特字符判断
 *
 * @author liuxinyun
 * @date 2019/4/7 19:17
 */
public class T0717OneBitCharacter {

    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        // 遇到1往前多挪一次，1比特字符在最后因为只跳一次，打破循环时正好等于length-1，
        while (i < bits.length - 1) {
            if (bits[i++] ==  1)
                ++i;
        }
        return i == bits.length-1;
    }

}
