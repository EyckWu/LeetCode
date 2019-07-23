[TOC]

## 双指针技巧

本章节中，我们将探讨双指针技巧，它可以帮助我们解决许多与数组/字符串相关的问题。

## 1. 双指针技巧 -- 情景一

在前一章节中，我们通过迭代数组解决一些问题。通常，我们只使用从第一个元素开始并在最后一个元素结束的一个指针来进行迭代。但是，有时候，我们可能需要同时使用两个指针来进行迭代。

### 示例

让我们从一个经典问题开始：反转数组中的元素。

其思想是将第一个元素与末尾元素进行交换，再向前移动到下一个元素，并不断地交换，直到它达到中间位置。

我们可以同时使用两个指针来进行迭代：一个从第一个元素开始，另一个从最后一个元素开始。持续交换他们所指向的元素，直到这两个指针相遇。

```
public static void reverse(int[] v, int N) {
    int i = 0;
    int j = N - 1;
    while (i < j) {
        swap(v, i, j);  // this is a self-defined function
        i++;
        j--;
    }
}
```

### 总结

总之，使用双指针技巧的典型场景之一是你想要从两端向中间迭代数组。这时你可以使用双指针技巧：一个指针从始端开始，而另一个指针从末端开始。
值得注意的是，这种技巧经常在排序数组中使用。

## 2. 反转字符串

编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。

不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。

示例 1：
```
输入：["h","e","l","l","o"]
输出：["o","l","l","e","h"]
```

示例 2：
```
输入：["H","a","n","n","a","h"]
输出：["h","a","n","n","a","H"]
```

```
public class Chapter41 {
    public static void main(String[] args){
        Chapter41 chapter41 = new Chapter41();
        char[] s = {'h','e','l','l','o'};
        chapter41.reverseString(s);
        Log.d(s);
    }

    public void reverseString(char[] s) {
        if (s == null || s.length <= 1){
            return;
        }
        int start = 0, end = s.length - 1;
        while(start < end){
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }
}
```

### 3. 数组拆分

给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。

示例 1:
```
输入: [1,4,3,2]

输出: 4
解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4)
```
.
提示:
```
n 是正整数,范围在 [1, 10000].
数组中的元素范围在 [-10000, 10000].
```

```
public class Chapter42 {
    public static void main(String[] args){
        Chapter42 chapter42 = new Chapter42();
        int[] nums = {1,4,3,2};
        Log.d(chapter42.arrsyPair(nums));
    }

    public int arrsyPair(int[] nums){
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2){
            sum += nums[i];
        }
        return sum;
    }
}
```

### 4. 两数之和 II - 输入有序数组

给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。

函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。

说明:

- 返回的下标值（index1 和 index2）不是从零开始的。
- 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。

示例:
```
输入: numbers = [2, 7, 11, 15], target = 9
输出: [1,2]
解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
```

```
public class Chapter43 {
    public static void main(String[] args){
        Chapter43 chapter43 = new Chapter43();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        Log.d(chapter43.twoSm(numbers, target));
    }

    public int[] twoSm(int[] numbers, int target){
        int start = 0, end = numbers.length - 1;
        while (start < end){
            if (numbers[start] + numbers[end] == target){
                return new int[]{start + 1, end + 1};
            } else if (numbers[start] + numbers[end] < target){
                start++;
            } else {
                end--;
            }
        }
        return new int[2];
    }
}
```

### 5. 双指针技巧 -- 情景2

有时，我们可以使用两个不同步的指针来解决问题。

#### 示例

让我们从另一个经典问题开始：给定一个数组和一个值，原地删除该值的所有实例并返回新的长度。

如果我们没有空间复杂度上的限制，那就更容易了。我们可以初始化一个薪的数组来存储答案。如果元素不等于给定的目标值，则迭代原始数组并将元素添加到薪的数组中。

实际上，它相当于使用了两个指针，一个用于原始数组的迭代，另一个总是指向新数组的最后一个位置。

#### 重新考虑空间限制

现在让我们重新考虑空间受限制的情况。

我们可以采用类似的策略，我们继续使用两个指针：一个仍然用于迭代，而第二个指针总是指向下一次添加的位置。

#### 总结

这是你需要使用双指针技巧的一种非常常见的情况：同时有一个慢指针和一个快指针。
解决这类问题的关键是：确定两个指针的移动策略。
与前一个场景类似，你有时可能需要使用双指针技巧之前对数组进行排序，也可能需要运用贪心想法来决定你的运动策略。

### 6. 移除元素

给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

示例 1:
```
给定 nums = [3,2,2,3], val = 3,

函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。

你不需要考虑数组中超出新长度后面的元素。
```
示例 2:
```
给定 nums = [0,1,2,2,3,0,4,2], val = 2,

函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。

注意这五个元素可为任意顺序。

你不需要考虑数组中超出新长度后面的元素。
```

```
public class Chapter44 {
    public static void main(String[] args){
        Chapter44 chapter44 = new Chapter44();
        int[] nums = {0,1,2,2,3,0,4,2};
        Log.d(chapter44.removeElement(nums, 2));
    }

    public int removeElement(int[] nums, int val){
        int k = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != val){
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}
```

### 7. 最大连续1的数

给定一个二进制数组， 计算其中最大连续1的个数。

示例 1:
```
输入: [1,1,0,1,1,1]
输出: 3
解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
```
注意：

- 输入的数组只包含 0 和1。
- 输入数组的长度是正整数，且不超过 10,000。

