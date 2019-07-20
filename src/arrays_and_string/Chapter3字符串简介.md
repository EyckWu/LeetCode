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