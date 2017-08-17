package com.algo.sort;

/**
 * Created by geng
 * on 2017/8/15.
 *
 * http://www.cnblogs.com/MOBIN/p/4681369.html
 * http://bubkoo.com/2014/01/14/sort-algorithm/heap-sort/
 */
public class BubbueSort {

    public static void main(String[] args) {
        int[] arr = {23, 1, 4, 0, 3, 21, 8};
//        int[] arr = {8, 1, 4, 0, 3, 21, 23};
        sort(arr);
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void sort(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
}
