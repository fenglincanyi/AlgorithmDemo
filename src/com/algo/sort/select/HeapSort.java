package com.algo.sort.select;

/**
 * Created by geng
 * on 2017/9/23.
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {23, 1, 1, 0, 3, 21, 7, 24};
        heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /*堆的筛选算法*/
    public static void sift(int[] arr, int start, int end) {
        int i = start;
        for (int j = 2 * i + 1; j <= end; j = 2 * j + 1) {// 重复操作至叶节点
            if (j < end && arr[j] < arr[j + 1]) {// 选出孩子节点最大的，后面来比较
                j++;
            }
            if (arr[i] >= arr[j]) {// 已经是堆了，不用调整
                break;
            } else {
                // 最大孩子上移至根节点
                swap(arr, i, j);
                i = j;
            }
        }
    }

    /*堆排序*/
    public static void heapSort(int[] arr) {
        for (int i = arr.length / 2; i >= 0; i--) {// 初始建堆，完全二叉树，只需从  n/2 中间节点处开始，向上
            sift(arr, i, arr.length - 1);
        }
        for (int i = arr.length - 1; i > 0; i--) {// 根节点和每次最后一个节点交换
            swap(arr, 0, i);
            sift(arr, 0, i - 1);
        }
    }


    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
