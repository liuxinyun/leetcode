package com.lxy.test.temp;

import org.junit.Test;

import java.util.Stack;

/**
 * 计算逆波兰表达式
 * 如果是数字入栈，如果是运算符，取出栈顶两个元素做运算，将结果入栈，最终栈里的元素就是结果
 *
 * @author liuxinyun
 * @date 2019/1/12 13:29
 */
public class StackEvalRPN {

    @Test
    public void test() {
        String[] a = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(a));
        String[] b = {"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(b));
    }

    private int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            try {
                int num = Integer.parseInt(token);
                stack.push(num);
            } catch (Exception e) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(get(a, b, token));
            }
        }
        return stack.pop();
    }

    private int get(int a,int b,String operator){
        switch (operator) {
            case "+":
                return a+b;
            case "-":
                return a-b;
            case "*":
                return a*b;
            case "/":
                return a/b;
            default:
                return 0;
        }
    }

}
