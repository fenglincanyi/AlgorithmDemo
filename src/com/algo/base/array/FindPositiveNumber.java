package com.algo.base.array;

/**
 * Created by geng
 * on 2017/9/22.
 * <p>
 *
 * 分离正负数   ||   调整数组顺序使奇数位于偶数前面
 */
public class FindPositiveNumber {

    public static void main(String[] args) {
        int[] arr = {-3, 2, -1, -4, 2, 9, 8, -2, -99};

        reorderOddEven(arr);

        print(arr);
    }


    public static void reorderOddEven(int[] arr) {
        // 对于输入的数组为空，或者长度小于2的只接返回
        if (arr == null || arr.length < 2) {
            return;
        }
        // 从左向右记录偶数的位置
        int start = 0;
        // 从右向左记录奇数的位置
        int end = arr.length - 1;
        // 开始调整奇数和偶数的位置
        while (start < end) {
            // 找偶数
            while (start < end && arr[start] % 2 != 0) { //  改成 正负数即可
                start++;
            }
            // 找奇数
            while (start < end && arr[end] % 2 == 0) { //  改成 正负数即可
                end--;
            }
            // 找到后就将奇数和偶数交换位置
            // 对于start=end的情况，交换不会产生什么影响
            // 所以将if判断省去了
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
        }
    }

    public static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}