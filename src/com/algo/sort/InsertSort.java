package com.algo.sort;

/**
 * Created by geng
 * on 2017/9/17.
 * <p>
 * 插入排序
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
        int temp;//存储要插入的数
        int i, j;//j:实际上用来记录位置

        for (i = 1; i < arr.length; i++) {
            temp = arr[i];// 暂时存储要插入的数
            if (arr[i] < arr[i - 1]) {
                for (j = i - 1; j >= 0 && temp < arr[j]; j--) {//遍历前面的数，进行比较，寻找插入的位置
                    arr[j + 1] = arr[j];//前面大的数后移
                }
                arr[j + 1] = temp;// j是刚好不满足情况的位置，则 j+1 满足该位置
            }
        }
    }

    public static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
