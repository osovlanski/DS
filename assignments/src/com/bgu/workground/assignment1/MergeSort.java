package com.bgu.workground.assignment1;

public class MergeSort {

    public static int[] mergeSort(int[] arr){
        if (arr == null)
            throw new NullPointerException();
        if (arr.length < 2)
            return arr;
        else {
            int[] arr1 = splitLeft(arr);
            int[] arr2 = splitRight(arr);
            int[] sorted1 = mergeSort(arr1);
            int[] sorted2 = mergeSort(arr2);
            return merge(sorted1, sorted2);
        }
    }

    private static int[] splitLeft(int[] arr){
        int[] output = new int[arr.length/2];
        for (int i = 0; i < arr.length/2; i = i+1)
            output[i] = arr[i];
        return output;
    }

    private static int[] splitRight(int[] arr){
        int[] output = new int[arr.length - arr.length/2];
        for (int i = arr.length/2; i < arr.length; i = i+1)
            output[i-arr.length/2] = arr[i];
        return output;
    }

    private static int[] merge(int[] arr1, int[] arr2) {
        int ind = 0, i1 = 0, i2 = 0;
        int len1 = arr1.length, len2 = arr2.length;
        int[] output = new int[len1 + len2];
        while(i1 < len1 & i2 < len2) {
            if (arr1[i1] < arr2[i2]) {
                output[ind] = arr1[i1];
                i1 = i1+1;
            }
            else {
                output[ind] = arr2[i2];
                i2 = i2+1;
            }
            ind = ind+1;
        }
        for(int i = i1; i < len1; i = i+1) {
            output[ind] = arr1[i];
            ind = ind+1;
        }
        for(int i = i2; i < len2; i = i+1) {
            output[ind] = arr2[i];
            ind = ind+1;
        }
        return output;
    }

}
