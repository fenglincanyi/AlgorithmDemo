package com.algo.base.number;

/**
 * Created by geng
 * on 2017/9/26.
 * <p>
 * 字符串 转 数字
 */
public class StrConvertNumber {

    public static void main(String[] args) {
        System.out.println(convertInt("908923"));
    }

    public static int convertInt(String str) {
        int flag = 1;
        int num = 0;
        char c = str.charAt(0);
        if (c == '+') {
            flag = 1;
            str = str.substring(1);
        } else if (c == '-') {
            flag = -1;
            str = str.substring(1);
        }

        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (c < '0' || c > '9') {// 不是数字
                return Integer.MIN_VALUE;
            } else {
                num = num * 10 + (c - '0');
            }
        }
        return flag * num;
    }
}
