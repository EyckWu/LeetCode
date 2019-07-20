package 数组和字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : EyckWu
 * @date : 2019/7/20
 * desc    : 杨辉三角
 */
public class Chapter24 {
    public static void main(String[] args){
        Chapter24 chapter24 = new Chapter24();
        System.out.println(chapter24.generate(5).toString());
    }

    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> triangle  = new ArrayList<>();
        if (numRows == 0) return triangle ;
        triangle .add(new ArrayList<Integer>());
        triangle.get(0).add(1);
        for (int i = 1; i < numRows; i++){
            List<Integer> row = new ArrayList<>();
            List<Integer> preRow = triangle.get(i - 1);
            row.add(1);
            for (int j = 1; j < i; j++){
                row.add(preRow.get(j - 1) + preRow.get(j));
            }
            row.add(1);
            triangle.add(row);
        }
        return triangle;
    }
}
