package com.itheima.algorithm.recursion_multi;

public class E03PascalTriangle {

    private static int element(int i, int j) {
        if (j == 0 || j == i) {
            return 1;
        }
        return element(i - 1, j - 1) + element(i - 1, j);
    }

    private static void printSpace(int n, int i) {
        int num = (n - i - 1) * 2;
        for (int j = 0; j < num; j++) {
            System.out.print(" ");
        }
    }

    public static void print(int n) {
        for (int i = 0; i < n; i++) {
            printSpace(n, i);
            for (int j = 0; j <= i; j++) {
                System.out.printf("%-4d", element(i, j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println(element(4, 2));
        print(5);
    }
}
