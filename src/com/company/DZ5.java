package com.company;

import java.util.ArrayList;
import java.util.Stack;

public class DZ5{

    public static void Quicksort(int[] array) {
        Quicksort(array, 0, array.length - 1);
    }

    public static void Quicksort(int[] array, int start, int end) {
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

    public static class Node {
        public int sum = 0;
        Node left;
        Node right;
        int val;
        public Node(int val) {
            this.val = val;
        }
        public Node(Node left, Node right, int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }

        public void print() {
            Stack<Node> nodes = new Stack<>();
            nodes.push(this);
            int l1 = 0;
            int r1 = 0;
            s(0, this);
            while (!nodes.isEmpty()) {
                Node node = nodes.pop();
                sum += node.val;
                if (node.left != null) {
                    nodes.push(node.left);
                    ++l1;
                    s(l1, node.left);
                }
                if (node.right != null) {
                    nodes.push(node.right);
                    ++r1;
                    s(r1, node.right);
                }
            }
            System.out.println("      " + this.val);
            s1();
        }

        static ArrayList<Object[]> stack = new ArrayList<>();

        void s(int line, Node node) {
            stack.add(new Object[]{line, node});
        }

        void s1() {
            int temp = 0;
            String s = "    ";
            for (Object[] arr: stack) {
                if (temp != (int) arr[0]) {
                    temp = (int) arr[0];
                    s += ((((Node) arr[1]).left != null) ? ((Node) arr[1]).left.val : "") + " " + ((((Node) arr[1]).right != null) ? ((Node) arr[1]).right.val : "") + "  ";
                }else
                    s += ((((Node) arr[1]).left != null) ? ((Node) arr[1]).left.val : "") + " " + ((((Node) arr[1]).right != null) ? ((Node) arr[1]).right.val : "") + "\n ";
            }
            System.out.println(s);
        }

    }

}
