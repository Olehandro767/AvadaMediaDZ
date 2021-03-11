package com.company;

public class DZ5{

    public static void Quicksort(int[] array) {
        Quicksort(array, 0, array.length - 1);
    }

    public static void Quicksort(int[] array, int start, int end) {
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (array[i] <= array[cur]))
                i++;
            while (j > cur && (array[cur] <= array[j]))
                j--;
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        Quicksort(array, start, cur);
        Quicksort(array,cur+1, end);
    }

    public static int BinarySearch(int[] array, int key) {
        return BinarySearch(array, key, 0, array.length - 1);
    }

    public static int BinarySearch(int[] array, int key, int low, int high) {
        while (low <= high) {
            int mid = low + (low + high) / 2;
            if (array[mid] < key)
                low = mid + 1;
            else if (array[mid] > key)
                high = mid - 1;
            else
                return mid;
        }
        return -1;
    }

}
