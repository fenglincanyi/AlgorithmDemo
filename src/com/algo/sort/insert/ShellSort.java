package com.algo.sort.insert;

/**
 * Created by geng
 * on 2017/9/23.
 * 希尔排序
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {23, 1, 4, 0, 3, 21, 8};
        print(arr);
        System.out.println();
        shellSort(arr);
        print(arr);
    }

    /**
     * 希尔排序：不稳定的排序
     * 对直接插入排序的 “终极优化”，分组进行直接插入排序
     * 时间复杂度： O(n^1.3),范围： [O(n^2), O(nlog2(n))]
     */
    public static void shellSort(int[] arr) {
        int d;// 数之间的间隔
        int temp;// 存储要插入的数
        int i, j;
        // 先对要排序的数，进行分组,间隔直到1
        for (d = arr.length / 2; d >= 1; d /= 2) {
            // i++,对每个分组交替执行排序，并不是一整个组排完
            for (i = d; i < arr.length; i++) {// 也是从该组的第二个数开始，和后面的数比较
                temp = arr[i];
                for (j = i - d; j >= 0 && temp < arr[j]; j -= d) {
                    arr[j + d] = arr[j];
                }
                arr[j + d] = temp;
            }
        }
    }


    public static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
