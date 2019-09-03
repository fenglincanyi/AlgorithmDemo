package com.algo.array;

/**
 * 合并2个有序数组
 * <p>
 * https://juejin.im/post/5bee5089e51d4538670b00d7
 *
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 说明:初始化 nums1 和 nums2 的元素数量分别为 m 和 n。你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:输入:nums1 = [1,2,3,0,0,0], m = 3nums2 = [2,5,6],       n = 3输出: [1,2,2,3,5,6]
 *
 * 思路：
 * 1. 用短的数组，挨个去比较 长数组，如果 a2[i] > a1[j] 记下位置 j
 * 2. 调整长数组, 依次向后调整，a1[k+1] = a[k]
 * 3. 插入到长数组中
 * 4. 调整 需要比较的索引位置，开始下次便利比较
 */
public class MergeOrderedArrays {

    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 3, 8, 9, 13, 29, 0, 0, 0, 0}; // 0 只是占位
        int[] arr2 = {1, 4, 10, 11};

        int m = 6, n = 4;

        arr1 = mergeArray(arr1, arr2, m, n);

        System.out.println("结果：");
        for (int i : arr1) {
            System.out.print(i + ", ");
        }
    }

    public static int[] mergeArray(int[] arr1, int[] arr2, int m, int n) {
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (arr1[j] < arr2[i]) {
                j++;
            }
            // 找到了插入位置
            for (int k = m + i - 1; k >= j && k < m + n - 1; k--) {
                arr1[k + 1] = arr1[k];
            }
            arr1[j] = arr2[i];
            j++;
        }
        return arr1;
    }
}
