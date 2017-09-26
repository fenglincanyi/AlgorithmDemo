package com.algo.number;

/**
 * Created by geng
 * on 2017/9/26.
 */
public class NumberCountOne {

    public static void main(String[] args) {
        System.out.println(countOne(1));
        System.out.println(countOne(3));
    }

    /**
     * 统计一个 树 转换成 2进制 后， 1的个数
     */
    public static int countOne(int n) {
        int count = 0;
        while (n > 0) {
            if ((n&1) == 1) {
                count ++;
            }
            n >>= 1;
        }
        return count;
    }
}
