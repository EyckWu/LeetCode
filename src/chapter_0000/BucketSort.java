package chapter_0000;

import java.util.Arrays;

public class BucketSort implements ISortArray {
    @Override
    public int[] sort(int[] sourceArray) {
        if (sourceArray.length <= 1){
            return sourceArray;
        }
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int bucketSize = 5;
        int maxValue = arr[0];
        int minValue = arr[0];
        for (int i = 0; i < arr.length; i++){
            if (maxValue < arr[i]){
                maxValue = arr[i];
            } else if (minValue > arr[i]){
                minValue = arr[i];
            }
        }
        int bucketCount = (int)Math.floor((maxValue - minValue) / bucketSize) + 1;
        int[][] buckets = new int[bucketCount][0];
        // 利用映射函数分配到各个桶中
        for (int i = 0; i < arr.length; i++){
            int index = (int)Math.floor((arr[i] - minValue) / bucketSize);
            buckets[index] = arrAppend(buckets[index], arr[i]);
        }
        int arrIndex = 0;
        ISortArray insertionSort = new InsertionSort();
        for (int[] bucket: buckets){
            if (bucket.length <= 0){
                continue;
            }
            bucket = insertionSort.sort(bucket);
            for (int value: bucket){
                arr[arrIndex++] = value;
            }
        }
        return arr;
    }

    private int[] arrAppend(int[] bucket, int ivalue) {
        bucket = Arrays.copyOf(bucket, bucket.length + 1);
        bucket[bucket.length - 1] = ivalue;
        return bucket;
    }
}
