package com.company;


import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[] {55, 38, 11, 30, 0, 14, 63, 53, 94, 9}; // 10

        //Quick sort
        System.out.println("\nQuick sort");
        DZ5.Quicksort(arr);
        System.out.println(Arrays.toString(arr));

        //Binary search
        System.out.println("\nBinary search");
        System.out.println(DZ5.BinarySearch(arr, 30));

        //Tree search (tree traversal)
        System.out.println("\ntree traversal");
        DZ5.Node nodes = new DZ5.Node(
                new DZ5.Node(
                        new DZ5.Node(
                                arr[6]
                        ),
                        new DZ5.Node(
                                arr[5]
                        ),
                        arr[7]
                ),
                new DZ5.Node(
                        new DZ5.Node(
                                new DZ5.Node(
                                        arr[4]
                                ),
                                new DZ5.Node(
                                        arr[3]
                                ),
                                arr[2]
                        ),
                        new DZ5.Node(arr[1]),
                        arr[8]
                ),
                arr[9]
        );
        nodes.print();
        //Big O
    }

}