package com.algo.base.array;

/**
 * 有个数组，长度为 n+1 ，有且只有1个数重复了2次，其他都不重复
 * 请找出这个数字
 *
 * https://leetcode-cn.com/problems/find-the-duplicate-number/solution/xun-zhao-zhong-fu-shu-by-leetcode/
 */
public class FindRepeatNumber {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 4};
        System.out.println(findDuplicate(arr));
    }

    public static int findDuplicate(int[] nums) {
        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            // 龟兔思想：快慢2个指针进行遍历
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        int ptr1 = nums[0];
        int ptr2 = tortoise;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }

        return ptr1;
    }


    /**
     * 一个数组中含有1001个元素，存放了1,2,3...1000和一个重复的数。
     * 只有唯一一个数是重复的，其它均只出现一次。要求设计一个算法找出这个重复的数，要求：每个数组元素只能访问一次，不用辅助存储空间。
     *
     * 主要利用了公式：a ^ b ^ a = b。
     *
     * @param nums
     * @return
     */
    int findRepeat(int[] nums) {
        int res = nums[0];
        int len = nums.length;
        for (int i = 1; i < len; i++)
        {
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }
}
