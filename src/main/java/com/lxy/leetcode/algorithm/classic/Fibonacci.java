package com.lxy.leetcode.algorithm.classic;

/**
 * @author liuxinyun
 * @date 2019/2/18 22:50
 */
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(tail(4, 1,1, 3));
    }

    /**
     * 普通写法
     */
    public static int fibonacci(int n){
        if(n<3) {
            return 1;
        } else {
            return fibonacci(n-1)+ fibonacci(n-2);
        }
    }

    /**
     * 尾递归优化
     */
    public static int fibonacciOptimized(int n) {
        if (n<3) {
            return 1;
        }else {
            return tail(n, 1, 1, 3);
        }
    }

    /**
     * 尾递归是指，在函数返回的时候，调用自身本身，并且，return语句不能包含表达式。
     * 优点：解决了递归过深，栈溢出问题
     */
    private  static int tail(int n, int b1, int b2, int c){
        if(n==c) {
            return b1+b2;
        } else {
            return tail(n, b2, b1+b2, c+1);
        }
    }
}
