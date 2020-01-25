[TOC]

## 字符串简介

正如我们在概览中提到的那样，字符串是一个由字符组成的数组。

本章节中，我们将深入研究字符串。完成本章后，你将：

- 熟悉字符串中的基本操作，尤其是在数组中没有的独特操作；
- 理解不同比较函数之间的区别；
- 判断字符串在你喜欢的语言中是否为不可变的并了解这个特性带来的影响；
- 能够解决与字符串相关的基本问题。

## 1. 字符串简介

字符串实际上是一个 unicode 字符数组。

### 比较函数

字符串有自己的比较函数，然而，存在这样一个问题：我们可以用 "==" 来比较两个字符串吗？
这取决于我们使用的语言是否支持运算符重载。

c++可以。java不可以，"=="实际上会比较这两个对象是否同一个对象。

### 是否可变

不可变意味着一旦字符串被初始化，就无法改变它的内容。

## 2. 不可变字符串 -- 问题和解决方案

### 修改操作

显然，不可变字符串无法被改变。哪怕只是想修改其中的一个字符，也必须创建一个新的字符串。

### 小心java中的字符串

在 for 循环中重复进行字符串连接。由于在java中字符串是不可变的，因此在连接时首先为新字符串分配足够的空间，复制旧字符串中的内容并附加到新的字符串。
因此，总时间复杂度是O(n^2)。c++没有明显的性能影响。

### 解决方案

1. 可以将其转换为字符数组。

2. 如果经常必须连接字符串，最好使用一些其他的数据结构，如StringBuilder.

## 3. 二进制求和

给定两个二进制字符串，返回他们的和（用二进制表示）。

输入为非空字符串且只包含数字 1 和 0。

示例 1:
```markdown
输入: a = "11", b = "1"
输出: "100"
```

示例 2:
```markdown
输入: a = "1010", b = "1011"
输出: "10101"
```


```java
public class Chapter31 {
    public static void main(String[] args){
        Chapter31 chapter31 = new Chapter31();
        String a = "1010", b = "1011";
        System.out.println(chapter31.addBinary(a, b));
    }

    public String addBinary(String a, String b){
        StringBuilder result = new StringBuilder();
        int al = a.length() - 1;
        int bl = b.length() - 1;
        int carry = 0;
        while (al >= 0 || bl >= 0){
            int sum = carry;
            if (al >= 0){
                sum += (a.charAt(al) - '0');
                al--;
            }
            if (bl >= 0){
                sum += (b.charAt(bl) - '0');
                bl--;
            }
            result.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0){
            result.append(1);
        }
        return result.reverse().toString();
    }
}
```

## 4. 实现strStr

实现 strStr() 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

示例 1:
```markdown
输入: haystack = "hello", needle = "ll"
输出: 2
```

示例 2:
```markdown
输入: haystack = "aaaaa", needle = "bba"
输出: -1
```
说明:

当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。

```java
public class Chapter32 {
    public static void main(String[] args){
        Chapter32 chapter32 = new Chapter32();
        String haystack = "hello", needle = "ll";
        Log.d(chapter32.strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle){
        if (needle == null || needle.isEmpty()){
            return 0;
        }
        if (haystack == null || haystack.isEmpty()){
            return -1;
        }
        char[] haystackArray = haystack.toCharArray();
        char[] needleArray = needle.toCharArray();
        char targetFirst = needleArray[0];
        int max = haystackArray.length;
        int targetCount = needleArray.length;
        for (int i = 0; i < max; i++){
            if (haystackArray[i] != targetFirst){
                while (++i < max && haystackArray[i] != targetFirst);
            }
            if (i < max){
                int j = i + 1;
                int end = j + targetCount - 1;
                if (end > max) {
                    return -1;
                }
                for (int k = 1; j < end && haystackArray[j] == needleArray[k]; j++,k++);
                if (j == end){
                    return i;
                }
            }
        }
        return -1;
    }
}
```

### 5. 最长公共前缀

编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:
```markdown
输入: ["flower","flow","flight"]
输出: "fl"
```

示例 2:
```markdown
输入: ["dog","racecar","car"]
输出: ""
```

解释: 输入不存在公共前缀。
说明:

所有输入只包含小写字母 a-z 。

横向扫描法

![](http://ww1.sinaimg.cn/large/6b0d07d7gy1g57dvc0gwfj20zk0q6dg7.jpg)

纵向扫描法

![](http://ww1.sinaimg.cn/large/6b0d07d7gy1g57dvypn6rj20rr0qoglx.jpg)

```java
public class Chapter33 {
    public static void main(String[] args){
        Chapter33 chapter33 = new Chapter33();
        String[] strs = {"flower","flow","flight"};
        Log.d(chapter33.longestCommentPrefix(strs));
        Log.d(chapter33.longestCommentPrefix2(strs));
        String[] strs2 = {"dog","racecar","car"};
        Log.d(chapter33.longestCommentPrefix(strs2));
        Log.d(chapter33.longestCommentPrefix2(strs2));
    }

    /**
     * 横向扫描法
     * @param strs
     * @return
     */
    public String longestCommentPrefix(String[] strs){
        if (strs == null || strs.length == 0){
            return "";
        }
        String result = strs[0];
        for (int i = 1; i < strs.length; i++){
            while (strs[i].indexOf(result) != 0){
                result = result.substring(0, result.length() - 1);
                if (result.length() == 0){
                    return "";
                }
            }
        }
        return result;
    }

    /**
     * 纵向扫描法
     * @param strs
     * @return
     */
    public String longestCommentPrefix2(String[] strs){
        if (strs == null || strs.length == 0){
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++){
            char c = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++){
                if (i == strs[j].length() || c != strs[j].charAt(i)){
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
```


