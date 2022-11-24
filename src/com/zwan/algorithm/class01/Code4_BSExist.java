package com.zwan.algorithm.class01;

import java.util.Arrays;

public class Code4_BSExist {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(exist(array, 1));
    }

    public static int exist(int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0) {
            return -1;
        }
        int l = 0;
        int r = sortedArr.length - 1;
        int mid;
        while (l < r) {
            // mid = l + (r - l) / 2;
            mid = l + ((r - l) >> 1);
            if (sortedArr[mid] == num) {
                return mid;
            } else if (sortedArr[mid] < num) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

}
