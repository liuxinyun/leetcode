package com.lxy.test.t600;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
 * 重复出现的子串要计算它们出现的次数。
 *
 * @author liuxinyun
 * @date 2019/4/15 23:09
 */
public class T0696CountBinarySubString {

    @Test
    public void test() {
        System.out.println(countBinarySubStrings("000110011"));
    }

    public int countBinarySubStrings(String s) {
        if (s==null || s.length()<2)
            return 0;
        List<Integer> list = new LinkedList<>();
        int count = 1;
        char c = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i)!=c){
                list.add(count);
                count = 1;
                c = s.charAt(i);
            }else {
                count++;
            }
        }
        list.add(count);
        int res = 0;
        for (int i = 0; i < list.size()-1; i++) {
            res += Math.min(list.get(i), list.get(i+1));
        }
        return res;
    }

}
