package com.lxy.test.niuke;

import java.util.Scanner;

/**
 * @author liuxinyun
 * @date 2019/1/23 23:57
 */
public class StringPasswordCheck {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String[] strArr = new String[num];
        for (int i = 0; i < num; i++) {
            strArr[i] = scanner.next();
        }
        String show;
        for (int i = 0; i < num; i++) {
            show = check(strArr[i]) ? "YES" : "NO";
            System.out.println(show);
        }
    }

    /**
     * 密码检查
     * 1. 密码只能由大写字母，小写字母，数字构成；
     * 2. 密码不能以数字开头；
     * 3. 密码中至少出现大写字母，小写字母和数字这三种字符类型中的两种；
     * 4. 密码长度至少为8
     *
     * @param password 待校验密码
     * @return true合法，false不合法
     */
    private static boolean check(String password) {
        String regex = "[a-zA-Z]{1}[a-zA-Z0-9]{7,}";
        boolean flag = password.matches(regex);
        if (!flag)
            return false;
        // 能匹配上判断至少两种类型是否满足
        int length = password.length();
        char c0 = password.charAt(0);
        String s;
        if (c0>='A' && c0<='Z') {
            s = password.replaceAll("[a-z0-9]", "");

        }else {
            s = password.replaceAll("[A-Z0-9]", "");
        }
        return s.length()<length;
    }
}
