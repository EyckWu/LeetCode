package 数组和字符串;

import java.util.Arrays;

/**
 * @author : EyckWu
 * @date : 2019/7/20
 * desc    : 对角线遍历
 */
public class Chapter22 {
    public static void main(String[] args){
        Chapter22 chapter22 = new Chapter22();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        System.out.println(Arrays.toString(chapter22.findDiagonalOrder(matrix)));
    }

    public int[] findDiagonalOrder(int[][] matrix){
        if (matrix.length == 0){
            return new int[0];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] result = new int[m * n];
        int r = 0, c = 0;
        for (int i = 0; i < result.length; i++){
            result[i] = matrix[r][c];
            if ((r + c)%2 == 0){
                if (c == n - 1){
                    r++;
                } else if (r == 0){
                    c++;
                } else {
                    c++;
                    r--;
                }
            } else {
                if (r == m -1){
                    c++;
                } else if (c == 0){
                    r++;
                } else {
                    r++;
                    c--;
                }
            }
        }
        return result;
    }
}
