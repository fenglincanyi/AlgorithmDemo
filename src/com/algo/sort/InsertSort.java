package com.algo.sort;

/**
 * Created by geng
 * on 2017/9/17.
 * <p>
 * 插入排序（寻找正确的插入位置）
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {23, 1, 4, 0, 3, 21, 8};
        print(arr);
        System.out.println();
        insertSort(arr);
        print(arr);
    }

    public static void insertSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j;
            for (j = i - 1; j >= 0 && tmp < arr[j];  j--) {// 找插入位置
                arr[j + 1] = arr[j];
            }
            arr[j+1] = tmp;
        }
    }

    public static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}