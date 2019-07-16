package chapter_0000;

import java.util.Arrays;

/**
 * @author : EyckWu
 * @date : 2019/7/13
 * desc    :
 */
public class HeadSort implements ISortArray {
    @Override
    public int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int length = arr.length;
        buildMaxHead(arr, length);
        for (int i = length - 1; i > 0; i--){
            swap(arr, 0, i);
            length --;
            heapify(arr, 0, length);
        }
        return arr;
    }

    private void buildMaxHead(int[] arr, int len){
        for (int i = (int)Math.floor(len / 2); i >= 0; i--){
            heapify(arr, i, len);
        }
    }

    private void heapify(int[] arr, int i, int len){
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < len && arr[left] > arr[largest]){
            largest = left;
        }
        if (right < len && arr[right] > arr[largest]){
            largest = right;
        }
        if (largest != i){
            swap(arr, i, largest);
            heapify(arr, largest, len);
        }
    }

    private void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
