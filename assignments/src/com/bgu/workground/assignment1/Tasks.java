package com.bgu.workground.assignment1;

public class Tasks {
    //0(1)+0(N) + o(Tasks) + O(1) + O(1) + O(N)
    public static String isSumExist(int sum,int []A1,int []A2){
        int []AA = new int[A1.length+A2.length];
        for (int i = 0; i < A1.length; i++) {
            AA[i] = A1[i];
            AA[A1.length+i] = A2[i];
        }
        AA = MergeSort.mergeSort(AA);//Tasks
        int start = 0; //0(1)
        int end = AA.length-1;//0(1)
        //doing 3n comparision
        while (start < end){
            if (AA[start] + AA[end] == sum)
                return "YES";
            if (AA[start] + AA[end] < sum)
                start++;
            else
                end --;
        }

        return "NO";

    }

    public static int getIndex(int []arr,int key){
        int left = 0,right = arr.length-1;
        while (left < right){
            int mid = (left+right)/2;
            //check if first half is sorted
            if (arr[left] <= arr[mid]){
                if (key <= arr[mid])
                    return binarySearch(arr,left,mid,key);
                else
                    left = mid+1; //checking the "unsorted" half
            }
            //check if second half is sorted
            if (arr[mid] <= arr[right]){
                if (key >= arr[mid])
                    return binarySearch(arr,mid,right,key);
                else
                    right = mid-1; //checking the "unsorted" half
            }
        }

        return -1;

    }

    private  static int binarySearch(int arr[], int l, int r, int key)
    {
        int output = -1;   // default (not found) value
        boolean found = false;
        int low = 0, high = arr.length-1;
        while (low <= high & !found){
            int middle = (low+high)/2;
            if(arr[middle] == key){
                output = middle;
                found = true;
            }
            else
            if (key < arr[middle])
                high = middle-1;
            else
                low = middle+1;
        }
        return output;
    }

}
