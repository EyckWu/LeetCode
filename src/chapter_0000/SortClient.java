package chapter_0000;

import java.util.Arrays;

public class SortClient {
    public static void main(String[] args){
        // 1. 冒泡排序
        bubbleSort();
    }

    /**
     * 冒泡排序
     */
    private static void bubbleSort(){
        int[] sourceArray = new int[]{2, 4, 6, 8, 1, 5, 8, 3, 7, 3 ,8, 0};
        ISortArray bubbleSort = new BubbleSort();
        bubbleSort.sort(sourceArray);
        System.out.println("sourceArray:" + Arrays.toString(sourceArray));
    }
}
