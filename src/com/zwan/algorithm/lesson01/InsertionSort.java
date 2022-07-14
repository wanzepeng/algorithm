package com.zwan.algorithm.lesson01;

import java.util.Arrays;
import java.util.Random;

/**
 * 插入排序
 * @author zwan
 * Create by zwan on 2022/5/18 22:23
 */
public class InsertionSort {

    public static void main(String[] args) {
        int testNum = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testNum; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            insertionSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        insertionSort(arr);
        printArray(arr);
    }

    public static void insertionSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        
    }

    private static void swap(int[] array, int i, int j) {
        // 因为不会出现数组中统一位置数比较，所以可用异或运算交换
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];

        /*int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;*/
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        Random random = new Random();
        int[] arr = new int[random.nextInt(maxSize)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(maxValue) - random.nextInt(maxValue);
        }
        return arr;
    }

    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return new int[0];
        }
        int[] copy = new int[arr.length];
        System.arraycopy(arr, 0, copy, 0, copy.length);
        return copy;
    }

    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

}
