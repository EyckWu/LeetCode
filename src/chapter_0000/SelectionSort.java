package chapter_0000;

public class SelectionSort implements ISortArray{
    @Override
    public int[] sort(int[] sourceArray) {
        int length = sourceArray.length;
        for (int i = 0; i < length; i++){
            int index = i;
            for (int j = i; j < length; j++){
                if (sourceArray[j] < sourceArray[index]){
                    index = j;
                }
            }
            if (sourceArray[index] < sourceArray[i]){
                int temp = sourceArray[index];
                sourceArray[index] = sourceArray[i];
                sourceArray[i] = temp;
            }
        }
        return sourceArray;
    }
}
