package chapter_0000;

import java.util.Arrays;

public class QuickSort implements ISortArray {
    @Override
    public int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        return quickSort(arr, 0, arr.length - 1);
    }

    private int[] quickSort(int[] arr, int left, int right){
        if (left < right){
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    private int partition(int[] arr, int left, int right){
        // 设置基准值(pivot)
        int pivot = left;
        int index = left + 1;
        for (int i = index; i <=right; i++){
            if (arr[i] < arr[pivot]){
                swap(arr, i , index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private void swap(int[] arr, int i, int index) {
        System.out.println("arr[i] = " + arr[i] + ";arr[index] = " + arr[index]);
        int tmp = arr[i];
        arr[i] = arr[index];
        arr[index] = tmp;
    }
}
