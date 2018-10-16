package practice;

import java.util.Arrays;

public class OrderAlgorithm {

    //快排
    public static void QuickSort(int[] a, int left, int right){
        if(left<right) {
            int key = a[left];
            int low = left;
            int high = right;
            while (left < right) {
                while (left < right && a[right] >= key)
                    right--;
                a[left] = a[right];
                while (left < right && a[left] <= key)
                    left++;
                a[right] = a[left];
            }
            a[right] = key;
            QuickSort(a, low, right - 1);
            QuickSort(a, right + 1, high);
//        return a;
        }
    }


    //归并
    public static void MergeSort(int[] a, int left, int right){
        if(left < right) {
            int mid = (right + left) / 2;
            MergeSort(a, left, mid);
            MergeSort(a, mid + 1, right);
            Merge(a, left, mid, right);
        }
    }
    public static void Merge(int[] a, int left, int mid, int right){
        int[] result = new int[right-left+1];
        int l1 = left;
        int r1 = mid + 1;
        int index =0;
        while(l1 <= mid && r1 <= right){
            if(a[l1] <= a[r1])
                result[index++] = a[l1++];
            else
                result[index++] = a[r1++];
        }
        while(l1<=mid)
            result[index++] = a[l1++];
        while(r1<=right)
            result[index++] = a[r1++];

        for(int i=0;i<result.length;i++){
            a[i+left] = result[i];
        }
    }


    //冒泡
    public static int[] BubbleSort(int[] a){
        int len = a.length;
        int temp;
        for(int i = 0; i < len; i++){
            for(int j = i+1; j < len; j++){
                if(a[i] > a[j]){
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a;
    }


    //插入
    public static int[] InsertSort(int[] a){
        int len = a.length;
        for(int i = 0; i < len; i++){
            int key = a[i];
            int j = i-1;
            while (j >= 0){
                if(key < a[j]){
                   a[j+1] = a[j];
                   a[j] = key;
                }
                j--;
            }
        }
        return a;
    }

    //希尔
    public static int[] ShellSort(int[] a){
        int len = a.length;
        int step = 2;
        int group = len / step;
        while(group > 0){
            for(int i = 0; i < group; i++){
                int j = i + group;
                while (j < len) {
                    int k = j - group;
                    int key = a[j];
                    while (k >= 0) {
                        if (a[k] > key) {
                            a[k + group] = a[k];
                            a[k] = key;
                        }
                        k -= group;
                    }
                    j += group;
                }
            }
            group/=step;
        }
        return a;
    }

    //选择
    public static int[] ChooseSort(int[] a){
        int len = a.length;
        int temp = 0;
        for(int i = 0; i < len; i++){
            int min = i;
            for(int j = i+1; j<len; j++){
                if(a[min] > a[j])
                    min = j;
            }
            temp = a[min];
            a[min] = a[i];
            a[i] = temp;
        }
        return a;
    }

    //堆排序
    public static void adjustHeap(int[] a, int i, int size){
        int lchild = 2*i+1;
        int rchild = 2*i+2;
        int max = i;
        if(i<size/2){
            if(lchild<size && a[lchild]>a[max])
                max = lchild;
            if(rchild<size && a[rchild]>a[max])
                max = rchild;
            if(max != i){
                int temp = a[max];
                a[max] = a[i];
                a[i] = temp;
                adjustHeap(a, max, size);
            }
        }
    }
    public static void buildHeap(int[] a, int size){
        for(int i = (size/2)-1; i>=0; i--){
            adjustHeap(a, i, size);
        }
    }
    public static void heapSort(int[] a){
        int size = a.length;
        buildHeap(a, size);
        for(int i = size-1; i>=0; i--){
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            adjustHeap(a, 0, i);
        }
    }

    //main方法
    public static void main(String args[]){
        int[] a = {16,14,10,8,7,9,3,2,4,1,50};//,36,99,5,3,6,46,10,9,1};

        QuickSort(a,0,a.length-1);
        System.out.println("QuickSort" + Arrays.toString(a));

//        MergeSort(a, 0, a.length-1);
//        System.out.println("MergeSort" + Arrays.toString(a));

//        int[] a3 = BubbleSort(a);
//        System.out.println("BubbleSort" + Arrays.toString(a3));

//        int[] a4 = InsertSort(a);
//        System.out.println("BubbleSort" + Arrays.toString(a4));

//        int[] a5 = ShellSort(a);
//        System.out.println("ShellSort" + Arrays.toString(a5));

//        int[] a6 = ChooseSort(a);
//        System.out.println("ChooseSort" + Arrays.toString(a6));

//        heapSort(a);
//        System.out.println("heapSort" + Arrays.toString(a));
    }
}
