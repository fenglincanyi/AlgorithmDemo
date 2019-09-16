package com.algo.leetcode;

/**
 * 【最长重复子串】
 * <p>
 * <p>
 * 给定字符串 S，找出最长重复子串的长度。如果不存在重复子串就返回 0。
 * <p>
 * 输入："abcd"
 * 输出：0
 * 解释：没有重复子串。
 * <p>
 * 输入："abbaba"
 * 输出：2
 * 解释：最长的重复子串为 "ab" 和 "ba"，每个出现 2 次。
 * <p>
 * 输入："aabcaabdaab"
 * 输出：3
 * 解释：最长的重复子串为 "aab"，出现 3 次。
 * <p>
 * 输入："aaaaa"
 * 输出：4
 * 解释：最长的重复子串为 "aaaa"，出现 2 次。
 */
public class MaxRepeatSubStr {

    public static void main(String[] args) {
        System.out.println(longestRepeatSubstring("abcd"));
        System.out.println(longestRepeatSubstring("abbaba"));
        System.out.println(longestRepeatSubstring("aabcaabdaab"));
        System.out.println(longestRepeatSubstring("aaaaa"));
    }

    /**
     * 动态规划
     * <p>
     * 设f(i,j)为S[i:i+k]与S[j:j+k]重复字符串的长度，并且S[i]==S[j]，那么会有
     * f(i,j)=f(i−1,j−1)+1。
     * 换句话说就是，如果S[i]==S[j]，那么i−1与j−1原有的重复字符串长度需要+1。
     * 这一考虑的空间复杂度为O(N)，时间复杂度为O(N2)
     */
    public static int longestRepeatSubstring(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        int res = 0;
        //第一层没什么特殊的，直接循环即可，需要注意的一点是跳出条件为len-res，因为当i超过len-res时，已经绝对不可能再出现大于res的结果了。直接跳出即可。
        for (int i = 0; i < len - res; i++) {
            int curr = 0;
            //注意这里j要从i+1开始计算，因为重复字符串肯定不能从相同起始索引比较起
            for (int j = i + 1, k = 0; j < len - res + curr; j++, k++) {
                // 注意这里比较的是k与j,
                if (chars[k] == chars[j]) {
                    curr++;
                    res = Math.max(res, curr);
                } else {
                    curr = 0;
                }
            }
        }
        return res;
    }
}
