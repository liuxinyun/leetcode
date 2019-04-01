package com.lxy.test.t100;

import org.junit.Test;

/**
 * @author liuxinyun
 * @date 2019/4/1 21:52
 */
public class T0006ZConvert {

    @Test
    public void test() {
        System.out.println(convert("LEETCODEISHIRING", 3));
        System.out.println(convert("LEETCODEISHIRING", 4));
    }

    public String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int cur = i;
            while (cur < length) {
                sb.append(s.charAt(cur));
                if (i > 0 && i < (numRows-1)){
                    // 除了第一行和最后一行，其余行需要算中间的值
                    int temp = cur + (numRows-1-i) * 2;
                    if (temp >= length) {
                        break;
                    }
                    sb.append(s.charAt(temp));
                }
                cur += (numRows-1) * 2;
            }
        }
        return sb.toString();
    }
}
