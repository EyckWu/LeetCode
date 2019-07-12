package chapter_0000;

public class InsertionSort implements ISortArray {
    @Override
    public int[] sort(int[] sourceArray) {
        for (int i = 1; i < sourceArray.length; i++){
            int j = i - 1;
            int temp = sourceArray[i];
            while (j >= 0 && sourceArray[j] > temp){
                sourceArray[j+1] = sourceArray[j];
                j--;
            }
            sourceArray[j+1] = temp;
        }
        return sourceArray;
    }
}
