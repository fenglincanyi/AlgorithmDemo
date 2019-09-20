package com.algo.leetcode;

/**
 * https://www.cnblogs.com/puyangsky/p/7048606.html
 * <p>
 * 最长公共子序列： 两个字符串中相同的子串序列，可以不连续。
 * 最长公共子串： 两个字符串中相同的连续子串。
 * <p>
 * 这两者的区别就在于子串是否需要连续。
 */
public class MaxSubSequence {

    public static void main(String[] args) {
        System.out.println(lcs("abcdef", "acef"));
        System.out.println(lcs1("abcdef", "acdef"));
    }

    /**
     * 最长公共子序列
     */
    public static int lcs(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) return 0;

        int len1 = s.length(), len2 = t.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        int max = 0;

        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    //和最长公共子串不一样的地方
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

                if (max < dp[i][j])
                    max = dp[i][j];
            }
        }

        return max;
    }


    /**
     * 最长公共子串
     */
    public static int lcs1(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) return 0;

        int len1 = s.length(), len2 = t.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        int max = 0;

        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                //处理i=0和j=0的情况，自底向上进行初始化
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }

                if (max < dp[i][j])
                    max = dp[i][j];
            }
        }

        return max;
    }

}
