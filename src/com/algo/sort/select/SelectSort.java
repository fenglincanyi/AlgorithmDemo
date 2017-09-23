package com.algo.sort.select;

/**
 * Created by geng
 * on 2017/8/15.
 * <p>
 * 选择排序(从无序区中选择最小的，与有序区的最后一个元素 交换)
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {23, 1, 1, 0, 3, 21, 23, 24};
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[index] > arr[j]) {
                    index = j;
                }
            }

            // 交换
            if (index != i) {
                arr[index] = arr[index] ^ arr[i];
                arr[i] = arr[index] ^ arr[i];
                arr[index] = arr[index] ^ arr[i];
            }
        }
    }
}