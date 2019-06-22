package chapter_0000;

public class BubbleSort implements ISortArray{

    @Override
    public int[] sort(int[] sourceArray) {
        int length = sourceArray.length;
        for (int i = 0; i < length - 1; i++){
            for (int j = 0; j < length - 1 - i; j++){
                if (sourceArray[j] > sourceArray[j+1]){
                    int temp = sourceArray[j+1];
                    sourceArray[j+1] = sourceArray[j];
                    sourceArray[j] = temp;
                }
            }
        }
        return sourceArray;
    }
}
