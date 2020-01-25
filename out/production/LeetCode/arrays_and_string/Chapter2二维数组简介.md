[TOC]

## 二维数组简介

前面的章节中，我们已经了解了一维数组。然而，有时候，我们可能需要用到多维数组，它更适合像表或矩阵这样更复杂的结构。

本章节中，我们将重点围绕二维数组来解释：

- 多维数组是如何工作的？
- 如何运用二维数组来解决问题？

### 1. 二维数组简介

类似于一维数组，二维数组也是由元素的序列组成。但是这些元素可以排列在矩阵网格中而不是直线上。

在一些语言中，多维数组实际上是在内部作为一维数组实现的，而在其他一些语言中，实际上根本没有多维数组。

1. c++ 将二维数组存储为一维数组

![](https://ws1.sinaimg.cn/large/6b0d07d7gy1g563rbzf7ij20tu032q35.jpg)

2. 在java中，二维数组实际上是包含着 m 个元素的一维数组，每个元素都是包含有 n 个整数的数组。

![](https://ws1.sinaimg.cn/large/6b0d07d7gy1g563sky8klj20mo0fu3zb.jpg)

### 2. 对角线遍历

给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。

示例:

```markdown
输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

输出:  [1,2,4,7,5,3,6,8,9]

解释:
```

![](https://ws1.sinaimg.cn/large/6b0d07d7gy1g564p2b0t1j20b30b60t4.jpg)

分析:
```markdown
分析一下遍历顺序的特点，可以看出，对角线的方向跟索引和（行的索引值+列的索引值）的奇偶性有关，然后加上边界情况，遍历的路线大概就出来了。

具体可以分为以下几种情况：

索引和为偶数：
元素在第一行，往右走
元素在最后一列，往下走
其他情况，往右上走

索引和为奇数：
元素在第一列，往下走
元素在最后一行，往右走
其他情况，往左下走
```

```java
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
```

### 3. 螺旋矩阵

给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。

示例 1:
```markdown
输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
输出: [1,2,3,6,9,8,7,4,5]
```

示例 2:
```markdown
输入:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
输出: [1,2,3,4,8,12,11,10,9,5,6,7]
```

```java
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
```

### 4. 杨辉三角

给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。

![](https://ws1.sinaimg.cn/large/6b0d07d7gy1g56avg2yzjg207806o3z0.gif)

在杨辉三角中，每个数是它左上方和右上方的数的和。

示例：
```markdown
输入: 5
输出:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
```

```java
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
```