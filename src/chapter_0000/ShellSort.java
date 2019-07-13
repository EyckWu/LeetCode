package chapter_0000;

public class ShellSort implements ISortArray {
    @Override
    public int[] sort(int[] sourceArray) {
        int gap = 1;
        while(gap < sourceArray.length){
            gap = gap * 3 + 1;
        }
        while(gap > 0){
            for (int i = gap; i < sourceArray.length; i++){
                int tmp = sourceArray[i];
                int j = i - gap;
                while (j >= 0 && sourceArray[j] > tmp){
                    sourceArray[j + gap] = sourceArray[j];
                    j -= gap;
                }
                sourceArray[j + gap] = tmp;
            }
            gap = (int)Math.floor(gap / 3);
        }
        return sourceArray;
    }
}
