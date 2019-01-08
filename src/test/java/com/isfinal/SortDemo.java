package com.isfinal;

/**
 * Created by wjb on 2019/1/3.
 */
public class SortDemo {

    //直接插入排序
    public static void insertSort(int[] arrs) {
        int temp;
        for (int i = 1; i < arrs.length; i++) {
            temp = arrs[i];//待插入的数据
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (arrs[j] > temp) {
                    arrs[j + 1] = arrs[j];
                } else {
                    break;
                }
            }
            arrs[j + 1] = temp;
        }
    }


    //简单选择排序
    public static void selectSort(int[] arrs) {
        for (int i = 0; i < arrs.length; i++) {
            int temp = arrs[i];
            int flag = i;
            for (int j = i + 1; j < arrs.length; j++) {
                if (arrs[j] < temp) {
                    temp = arrs[j];
                    flag = j;
                }
            }
            if (flag != i) {
                arrs[flag] = arrs[i];
                arrs[i] = temp;
            }
        }
    }

    //冒泡排序
    public static void bubbleSort(int[] arrs) {
        for (int i = 0; i < arrs.length - 1; i++) {
            for (int j = 0; j < arrs.length - 1 - i; j++) {
                if (arrs[j] > arrs[j + 1]) {
                    int temp = arrs[j];
                    arrs[j] = arrs[j + 1];
                    arrs[j + 1] = temp;
                }
            }
        }
    }

    //快速
    private static void fastSort(int[] a, int low, int high) {
        //1,找到递归算法的出口
        if (low > high) {
            return;
        }
        //2, 存
        int i = low;
        int j = high;
        //3,key
        int key = a[low];
        //4，完成一趟排序
        while (i < j) {
            //4.1 ，从右往左找到第一个小于key的数
            while (i < j && a[j] > key) {
                j--;
            }
            // 4.2 从左往右找到第一个大于key的数
            while (i < j && a[i] <= key) {
                i++;
            }
            //4.3 交换
            if (i < j) {
                int p = a[i];
                a[i] = a[j];
                a[j] = p;
            }
        }
        // 4.4，调整key的位置
        int p = a[i];
        a[i] = a[low];
        a[low] = p;
        //5, 对key左边的数快排
        fastSort(a, low, i - 1);
        //6, 对key右边的数快排
        fastSort(a, i + 1, high);
    }





    public static void main(String[] args) {
        int[] a = {2, 5, 3, 1, 4, 8, 9, 7, 6,10};
        insertSort(a);
//        fastSort(a, 0, a.length - 1);
        for (int i : a) {
            System.out.println(i);
        }
    }


}
