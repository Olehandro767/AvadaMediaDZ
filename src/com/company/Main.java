package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[] {55, 38, 11, 30, 0, 14, 63, 53, 94, 9};

        //Quick sort
        System.out.println("\nQuick sort");
        DZ5.Quicksort(arr);
        System.out.println(Arrays.toString(arr));

        //Binary search
        System.out.println("\nBinary search");
        System.out.println(DZ5.BinarySearch(arr, 30));

        //Tree search (tree traversal)

        //Big O
    }

}