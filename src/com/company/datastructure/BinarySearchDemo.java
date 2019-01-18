package com.company.datastructure;

public class BinarySearchDemo {
    public static int BinarySearch(int arr[], int value, int length){
        int low = 0;
        int high = length -1;
        int mid;

        while(low <= high){
            mid = (low + high)/2;
            if(arr[mid] == value)
                return mid;
            else if(arr[mid] > value)
                high = mid -1;
            else
                low = mid + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int target = 66;
        int arr[] = {1,2,3,9,22,33,44,55,66,77,88,99,100};

        int result = BinarySearch(arr, target, arr.length);

        System.out.println("Result: " + result);
    }
}
