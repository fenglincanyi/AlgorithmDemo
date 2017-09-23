package com.algo.array;

/**
 * Created by geng
 * on 2017/9/22.
 * <p>
 * 分离正负数
 */
public class FindPositiveNumber {

    public static void main(String[] args) {
        int[] arr = {-3, 2, -1, -4, 2, 9, 8, -2, -99};

//        find(arr);


        print(arr);
    }

    public static void find(int[] arr) {
        int n = arr.length - 1;
        for (int i = 0; i <= n - 2; i++) {
            if (arr[i] > 0) {
                arr[i] = arr[i] ^ arr[n - 1];
                arr[n - 1] = arr[i] ^ arr[n - 1];
                arr[i] = arr[i] ^ arr[n - 1];
                --i;
            }
        }
//        if (arr[n-1] < 0 && arr[n-2] > 0) {
//            arr[i] = arr[i] ^ arr[n - 1];
//            arr[n - 1] = arr[i] ^ arr[n - 1];
//            arr[i] = arr[i] ^ arr[n - 1];
//        }
    }


    public static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}