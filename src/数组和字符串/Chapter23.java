package 数组和字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : EyckWu
 * @date : 2019/7/20
 * desc    : 螺旋矩阵
 */
public class Chapter23 {
    public static void main(String[] args){
        Chapter23 chapter23 = new Chapter23();
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        System.out.println(chapter23.spiralOrder(matrix).toString());
    }

    public List<Integer> spiralOrder(int[][] matrix){
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0){
            return res;
        }
        int top = 0, left = 0, bottom = matrix.length - 1, right = matrix[0].length - 1;
        while (true){
            for (int i = left; i <= right; i++){
                res.add(matrix[top][i]);
            }
            top++;
            if (top > bottom || left > right) break;
            for (int i = top; i <= bottom; i++){
                res.add(matrix[i][right]);
            }
            right--;
            if (top > bottom || left > right) break;
            for (int i = right; i >= left; i--){
                res.add(matrix[bottom][i]);
            }
            bottom--;
            if (top > bottom || left > right) break;
            for (int i = bottom; i >= top; i--){
                res.add(matrix[i][left]);
            }
            left++;
            if (top > bottom || left > right) break;
        }
        return res;
    }
}
