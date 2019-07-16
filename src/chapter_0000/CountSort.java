package chapter_0000;

import java.util.Arrays;

public class CountSort implements ISortArray {
    @Override
    public int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int maxValue = getMaxValue(arr);
        int[] bucket = new int[maxValue + 1];
        for (int i = 0; i < arr.length; i++){
            bucket[arr[i]]++;
        }
        System.out.println("bucket = " + Arrays.toString(bucket));
        int sortIndex = 0;
        for (int i = 0; i < bucket.length; i++){
            while (bucket[i] > 0) {
                arr[sortIndex++] = i;
                bucket[i]--;
            }
        }
        return arr;
    }

    private int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (maxValue < arr[i]){
                maxValue = arr[i];
            }
        }
        return maxValue;
    }
}
