package search;

import java.util.Arrays;

public class Search {
    
    public static void main(String[] args) {
        int[] arr = new int[]{108, 1072, -16, -35, 932, 75};
        arr = Search.selectionSort(arr);
        System.out.printf(Arrays.toString(arr));
    }
    
    // return -1 if val not found 
    public static int search(int[] arr, int val) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                return i;
            }
        }
        return -1;
    }
    
    public static int binarySearch(int[] arr, int val) {
        int start = 0;
        int end = arr.length;  // last index + 1
        while (start < end) {
            int mid = start + ((end - start) / 2);
            System.out.printf("Start: %d, end: %d, mid: %d\n", start, end, mid);
            if (arr[mid] == val) {
                return mid;
            } else if (arr[mid] < val) {
                start = mid + 1;
            } else { // if (arr[mid] > val)
                end = mid;
            }
        }
        return -1;
    }
    
    public static int[] selectionSort(int[] arr) {
        int[] sorted = new int[arr.length]; 
        int len = arr.length;
        for (int i = 0; i < arr.length; i++) {
            int minIdx = Search.min(arr, len);
            sorted[i] = arr[minIdx];
            arr[minIdx] = arr[len - 1];
            len--;
        }
        return sorted;
    }
    
    public static int min(int[] arr, int len) {
        int minIdx = 0;
        int min = arr[0];
        for (int i = 0; i < len; i++) {
            if (arr[i] < min) {
                min = arr[i];
                minIdx = i;
            }
        }
        return minIdx;
    }
}
