package com.itheima.algorithm.binarysearch;

public class BinarySearch {

    /**
     * 二分查找基本版
     *
     * @param a      待查找的升序数组
     * @param target 待查找的目标值
     * @return 找到则返回索引，找不到返回 -1
     */
    public static int binarySearchBasic(int[] a, int target) {
        int i = 0, j = a.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m - 1;
            } else if (target > a[m]) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return -1;

    }

    /**
     * 二分查找改动版
     *
     * @param a      待查找的升序数组
     * @param target 待查找的目标值
     * @return 找到则返回索引，找不到返回 -1
     */

    public static int binarySearchAlternative(int[] a, int target) {
        int i = 0, j = a.length;
        while (i < j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m;
            } else if (target > a[m]) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }


    /***
     * 二分查找平衡版
     * @param a
     * @param target
     * @return
     */
    public static int binarySearchBalance(int[] a, int target) {
        int i = 0, j = a.length;
        while (1 < j - i) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m;
            } else {
                i = m;
            }
        }

        return (target == a[i]) ? i : -1;
    }

    /***
     * 二分查找左最左版
     * @param a
     * @param target
     * @return
     */
    public static int binarySearchLeftmost1(int[] a, int target) {
        int i = 0, j = a.length - 1;
        int candidate = -1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m - 1;
            } else if (target > a[m]) {
                i = m + 1;
            } else {
                //     记录候选位置
                candidate = m;
                j = m - 1;
            }
        }
        return candidate;
    }

    /***
     * 二分查找右最右版
     * @param a
     * @param target
     * @return
     */
    public static int binarySearchRightmost1(int[] a, int target) {

        int i = 0, j = a.length - 1;
        int candidate = -1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m - 1;
            } else if (target > a[m]) {
                i = m + 1;
            } else {
                //     记录候选位置
                candidate = m;
                i = m + 1;
            }
        }
        return candidate;
    }

    /***
     * 二分查找左最左版
     * @param a
     * @param target
     * @return
     */
    public static int binarySearchLeftmost2(int[] a, int target) {
        int i = 0, j = a.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target <= a[m]) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return i;
    }

    /***
     * 二分查找右最右版
     * @param a
     * @param target
     * @return
     */
    public static int binarySearchRightmost2(int[] a, int target) {

        int i = 0, j = a.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return i - 1;
    }


}
