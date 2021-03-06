[TOC]

## 数组简介

本章节中，我们将介绍两个重要的概念：数组和动态数组。

这是你应当熟悉的基本数据结构。 我们也为你提供了使用内置的数组和动态数组的教程。

完成本章后，你将能够回答以下问题：

- 数组和动态数组之间有什么不同？
- 在你常用的语言中，数组和动态数组对应的内置数据结构是什么？
- 如何在数组中执行初始化、数据访问、修改、迭代、排序等基本操作？
- 如何在动态数组中执行初始化、数据访问、修改、迭代、排序、添加、删除等基本操作？

### 1. 数组简介

数组是一种基本的数据结构，用于按顺序存储元素的集合。但是元素可以随机存取，因为数组中的每个元素都可以通过索引来识别。

数组可以有一个维度或多个维度。这里我们从一维数组开始，它被称为线性数组。

![](http://ww1.sinaimg.cn/large/6b0d07d7gy1g4zri73dygj20v806waah.jpg)

在上面的例子中，数组A有6个元素，也就是说A的长度是6。我们可以用A[0]来表示数组中的第一个元素。因此，A[0] = 6.

数组中的操作

```
// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        // 1. Initialize
        int[] a0 = new int[5];
        int[] a1 = {1, 2, 3};
        // 2. Get Length
        System.out.println("The size of a1 is: " + a1.length);
        // 3. Access Element
        System.out.println("The first element is: " + a1[0]);
        // 4. Iterate all Elements
        System.out.print("[Version 1] The contents of a1 are:");
        for (int i = 0; i < a1.length; ++i) {
            System.out.print(" " + a1[i]);
        }
        System.out.println();
        System.out.print("[Version 2] The contents of a1 are:");
        for (int item: a1) {
            System.out.print(" " + item);
        }
        System.out.println();
        // 5. Modify Element
        a1[0] = 4;
        // 6. Sort
        Arrays.sort(a1);
    }
}
```

### 2. 动态数组简介

数组具有固定的容量，我们需要在初始化的时候指定数组的大小。有时它会非常不方便并可能造成浪费。

因此，大多数编程语言都提供内置的动态数组，它仍然是一个随机存取的列表数据结构，但大小是可变的。

```
// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        // 1. initialize
        List<Integer> v0 = new ArrayList<>();
        List<Integer> v1;                           // v1 == null
        // 2. cast an array to a vector
        Integer[] a = {0, 1, 2, 3, 4};
        v1 = new ArrayList<>(Arrays.asList(a));
        // 3. make a copy
        List<Integer> v2 = v1;                      // another reference to v1
        List<Integer> v3 = new ArrayList<>(v1);     // make an actual copy of v1
        // 3. get length
        System.out.println("The size of v1 is: " + v1.size());;
        // 4. access element
        System.out.println("The first element in v1 is: " + v1.get(0));
        // 5. iterate the vector
        System.out.print("[Version 1] The contents of v1 are:");
        for (int i = 0; i < v1.size(); ++i) {
            System.out.print(" " + v1.get(i));
        }
        System.out.println();
        System.out.print("[Version 2] The contents of v1 are:");
        for (int item : v1) {
            System.out.print(" " + item);
        }
        System.out.println();
        // 6. modify element
        v2.set(0, 5);       // modify v2 will actually modify v1
        System.out.println("The first element in v1 is: " + v1.get(0));
        v3.set(0, -1);
        System.out.println("The first element in v1 is: " + v1.get(0));
        // 7. sort
        Collections.sort(v1);
        // 8. add new element at the end of the vector
        v1.add(-1);
        v1.add(1, 6);
        // 9. delete the last element
        v1.remove(v1.size() - 1);
    }
}
```

### 3. 寻找数组的中心索引

给定一个整数类型的数组 nums, 请编写一个能够返回数组“中心索引”的方法。

我们是这样定义数组中心索引的： 数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。

如果数组不存在中心索引，我们应该返回 -1.如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。

示例1：

```
输入: 
nums = [1, 7, 3, 6, 5, 6]
输出: 3
解释: 
索引3 (nums[3] = 6) 的左侧数之和(1 + 7 + 3 = 11)，与右侧数之和(5 + 6 = 11)相等。
同时, 3 也是第一个符合要求的中心索引。
```

实例2：

```
输入: 
nums = [1, 2, 3]
输出: -1
解释: 
数组中不存在满足此条件的中心索引。
```

```
public class Chapter13 {
    public static void main(String[] args){
        Chapter13 chapter13 = new Chapter13();
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(chapter13.pivotIndex(nums));
        int[] nums2 = {1, 2, 3};
        System.out.println(chapter13.pivotIndex(nums2));

    }

    public int pivotIndex(int[] nums){
        int sum = sum(nums);
        for (int i = 0; i < nums.length; i++){
            int[] tmp = Arrays.copyOf(nums, i + 1);
            int tmpSum = sum(tmp);
            if (tmpSum * 2 == sum + nums[i]){
                return i;
            }
        }
        return -1;
    }

    private int sum(int[] nums){
        int sum  = 0;
        if (nums.length == 0){
            return sum;
        }
        for (int num: nums){
            sum += num;
        }
        return sum;
    }
}
```

### 4. 至少是其他数字两倍的最大数

在一个给定的数组nums中，总是存在一个最大元素 。

查找数组中的最大元素是否至少是数组中每个其他数字的两倍。

如果是，则返回最大元素的索引，否则返回-1。

示例 1:
```markdown
输入: nums = [3, 6, 1, 0]
输出: 1
解释: 6是最大的整数, 对于数组中的其他整数,
6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.
```

 

示例 2:
```markdown
输入: nums = [1, 2, 3, 4]
输出: -1
解释: 4没有超过3的两倍大, 所以我们返回 -1.
```

分析:
```markdown
解法一：直接找到最大元素，然后遍历每个元素，看是不是它是每个元素的2倍。这是最简单的方法，保底用的，但是效率很低。

解法二：找到最大和第二大的元素，看最大的是不是第二大的2倍，若不是直接返回-1.若是，在数组中找到它的索引。
```

```java
public class Chapter14 {
    public static void main(String[] args){
        Chapter14 chapter14 = new Chapter14();
        int[] nums = {3, 6, 1, 0};
        System.out.println(chapter14.dominantIndexAdvance(nums));
        int[] nums2 = {1, 2, 3, 4};
        System.out.println(chapter14.dominantIndexAdvance(nums2));
    }

    public int dominantIndexAdvance(int[] nums){
        if (nums.length == 0){
            return -1;
        }
        if (nums.length == 1){
            return 0;
        }
        int max = -1;
        int second = -1;
        int index = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > max){
                second = max;
                max = nums[i];
                index = i;
            } else if (nums[i] > second){
                second = nums[i];
            }
        }
        return max >= second * 2 ? index : -1;
    }

    public int dominantIndex(int[] nums){
        if (nums.length == 0){
            return -1;
        }
        if (nums.length == 1){
            return 0;
        }
        int maxIndex = maxNumIndex(nums);
        for (int i = 0; i < nums.length; i++){
            if (maxIndex != i && nums[maxIndex] < nums[i] * 2){
                return -1;
            }
        }
        return maxIndex;
    }

    private static int maxNumIndex(int[] nums){
        int index = -1;
        for (int i = 0; i < nums.length; i++){
            if (nums[index] < nums[i]){
                index = i;
            }
        }
        return index;
    }
}
```

### 5. 加一

给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1:
```markdown
输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。
```
示例 2:
```markdown
输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。
```

```java
public class Chapter15 {
    public static void main(String[] agrs){
        Chapter15 chapter15 = new Chapter15();
        int[] digits = {1, 2, 3};
        System.out.println(Arrays.toString(chapter15.plusOne(digits)));
        int[] digits2 = {9, 9, 9};
        System.out.println(Arrays.toString(chapter15.plusOne(digits2)));
    }

    public int[] plusOne(int[] digits){
        int[] arr = Arrays.copyOf(digits, digits.length);
        if (digits.length == 0){
            return arr;
        }
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--){
            if (carry == 0){
                return arr;
            }
            int tmp = arr[i] + carry;
            carry = tmp / 10;
            arr[i] = tmp % 10;
        }
        if (carry != 0){
            int[] arr2 = new int[arr.length + 1];
            System.arraycopy(arr, 0, arr2, 1, arr.length);
            arr2[0] = 1;
            return arr2;
        }
        return arr;
    }
}
```