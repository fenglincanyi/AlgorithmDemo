package com.algo.sort.swap;

/**
 * Created by geng
 * on 2017/8/15.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {23, 1, 4, 0, 3, 21, 8};
        print(arr);
        System.out.println();
        quickSort(arr, 0, arr.length - 1);
        print(arr);
    }

    /**
     * 快速排序,对冒泡排序的改进,不稳定
     * O(nlog2n),最差情况下：退化为冒泡排序O(n^2)
     */
    public static void quickSort(int arr[], int left, int right) {
        if (left < right) {
            // 递归进行排序
            int q = partition(arr, left, right);
            quickSort(arr, left, q - 1);//左半边
            quickSort(arr, q + 1, right);//右半边
        }
    }

    /**
     * 选取基准元素key，进行划分
     * 左右2个指针，重合，则本次迭代结束，返回位置 i
     */
    public static int partition(int arr[], int left, int right) {
        int i = left;
        int j = right;
        int key = arr[i];
        while (i < j) {
            while (i < j && key < arr[j]) {//右侧扫描
                j--;
            }
            arr[i] = arr[j];
            while (i < j && arr[i] < key) {//左侧扫描
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = key;//一轮循环完，找到key的位置
        return i;
    }


    public static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}