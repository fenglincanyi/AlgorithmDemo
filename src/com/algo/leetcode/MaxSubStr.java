package com.algo.leetcode;

/**
 * 【无重复字符的最长子串】
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class MaxSubStr {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int size, i = 0, j, k, max = 0;
        size = s.length();
        for (j = 0; j < size; j++) {
            for (k = i; k < j; k++) {
                if (s.charAt(k) == s.charAt(j)) {
                    i = k + 1;
                    break;
                }
            }
            if (j - i + 1 > max) {
                max = j - i + 1;
            }
        }
        return max;
    }
}
