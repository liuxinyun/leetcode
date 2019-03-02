package com.lxy.leetcode.algorithm.find;

/**
 * 从回溯法到kmp
 * 参考博文：http://www.cnblogs.com/yjiyjige/p/3263858.html
 *
 * @作者: liuxinyun
 * @日期: 2017/5/18 13:58
 * @描述:
 */
public class KMP {

    /**
     * 回溯法字符串模式匹配
     * @param s
     * @param p
     * @return
     */
    public static int reback(String s, String p){
        int i=0;//主串位置
        int j=0;//模式串位置
        while (i<s.length() && j<p.length()){
            if (s.charAt(i) == p.charAt(j)){
                ++i;
                ++j;
            }else {
                //i回溯，重新开始匹配位置(此处是kmp算法改进的地方)
                i = i-j+1;//退回到最开始时比较的位置
                j = 0;
            }
        }
        if (j == p.length()) {
            return i-p.length();
        }
        return -1;
    }

    /**
     * kmp算法模式匹配
     *
     * @param s
     * @param p
     * @return
     */
    public static int kmp(String s, String p){
        int i = 0;//主串位置
        int j = 0;//模式位置
        int[] next = getNext(p);
        while (i<s.length() && j<p.length()){
            if (j==-1 || s.charAt(i)==p.charAt(j)){//当j为-1时，需要移动i，j归零。
                ++i;
                ++j;
            }else {
                //i不需要回溯了
                //i = i-j+1;
                j = next[j];//j回到指定位置
            }
        }
        if (j == p.length()) {
            return i-p.length();
        }
        return -1;
    }

    /**
     * 获取模式串的next[]，用于kmp
     * @param ps
     * @return
     */
    private static int[] getNext(String ps){
        char[] p = ps.toCharArray();
        int[] next = new int[p.length];
        next[0] = -1;//考虑开头就不能匹配，那么j已经在最左边了，不能移动，只能i后移
        int j = 0;
        int k = -1;
        while (j < p.length-1){
            if (k==-1 || p[j]==p[k]){
                //next[++j] = ++k;
                //下面是进行了进一步的优化，防止出现p[next[j]]=p[j]
                if (p[++j] == p[++k]){
                    //当两个字符相等时跳过
                    next[j] = next[k];
                } else {
                    next[j] = k;
                }
            }else {
                k = next[k];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println(reback("abacababc","abab"));
        System.out.println(kmp("abacababc","abab"));
    }

}
