package com.algo.base.find;

/**
 * Created by geng
 * on 2017/9/7.
 *
 * 2种实现思路：循环 / 递归：注意结束的边界
 */
public class BinarySearch {

    public static void main(String[] args) {
        long[] arr = {2, 4, 8, 9, 19, 23};
        System.out.println("位置：" + binarySearch(arr, 0, arr.length - 1, 4));
    }

    /**
     * jdk 源码中的二分查找
     */
    private static int binarySearch(long[] a, int fromIndex, int toIndex,
                                    long key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            long midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }
}
