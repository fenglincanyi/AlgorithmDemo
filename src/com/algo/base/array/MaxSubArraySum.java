package com.algo.base.array;

/**
 * Created by geng
 * on 2017/9/13.
 */
public class MaxSubArraySum {

    public static void main(String[] args) {
//        int[] arr = {4, 0, -1, , 20, -9, 9, 4, -8, 92};
//        int[] arr = {4, 2, -1, -2};
        int[] arr = {-1, -1, 0, -2, -3};
        getSubArrayMax(arr);

    }


    /**
     * 最大子数组和
     *
     * 求一个连续的区间的最大值
     *
     * 如果要求 位置区间，可加入 start,end, 否则可忽略
     */
    public static void getSubArrayMax(int[] arr) {
        int sum = arr[0];
        int tmp = 0;
        int start = 0, end = 0;// 结束位置
        int i, j;

        for (i = 0; i < arr.length; i++) {
            if (tmp > 0) {
                tmp += arr[i];
            } else {
                tmp = arr[i];
            }

            if (sum < tmp) {
                sum = tmp;
                end = i;
            }
        }

        tmp = sum;
        for (j = end; j >= 0; j--) {
            tmp -=  arr[j];
            if (tmp == 0) {
                start = j;
                break;
            }
        }
        System.out.println(sum + " ==== [" + start + ", " + end + "]");
    }
}
