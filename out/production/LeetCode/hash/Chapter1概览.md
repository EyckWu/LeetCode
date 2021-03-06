[TOC]

## 介绍

哈希表是一种使用哈希函数组织数据，以支持快速插入和搜索的数据结构。

有两种不同类型的哈希表：哈希集合和哈希映射：

> 哈希集合(HashSet)是集合数据结构的实现之一，用于存储非重复值；  
> 哈希映射(HashMap)是映射数据结构的实现之一，用于存储(key, value)键值对。

通过选择合适的hash函数，哈希表可以在插入和搜索方面实现出色的性能。

在这张卡片中，我们讲回答以下问题：

1. 哈希表的原理是什么？
2. 如何设计哈希表？
3. 如何使用哈希集合来解决与重复相关的问题？
4. 如何使用哈希映射来按键聚合信息？
5. 如何在使用哈希表时设计正确的键？

## 设计哈希表

### 1. 哈希表的原理是什么

哈希表的关键思想是使用哈希函数将键映射到存储桶中。更确切的说，

1. 当我们插入一个新的键时，哈希函数将决定该键应该分配到哪个桶中，并将该键存储在相应的桶中。
2. 当我们想要搜索一个键时，哈希表将使用相同的哈希函数来查找对应的桶，并只在特定的桶中进行搜索。

示例：

![hash原理](https://aliyun-lc-upload.oss-cn-hangzhou.aliyuncs.com/aliyun-lc-upload/uploads/2018/09/06/screen-shot-2018-02-19-at-183537.png)

在示例中，我们使用 y = x ％ 5 作为哈希函数。让我们使用这个例子来完成插入和搜索策略：

1. 插入：我们通过哈希函数解析键，将它们映射到相应的桶中。  
例如，1987 分配给桶 2，而 24 分配给桶 4。

2. 搜索：我们通过相同的哈希函数解析键，并仅在特定存储桶中搜索。  
如果我们搜索 1987，我们将使用相同的哈希函数将1987 映射到 2。因此我们在桶 2 中搜索，我们在那个桶中成功找到了 1987。  
例如，如果我们搜索 23，将映射 23 到 3，并在桶 3 中搜索。我们发现 23 不在桶 3 中，这意味着 23 不在哈希表中。

### 2. 哪些因素会影响哈希函数以及冲突解决策略的选择？

在设计哈希表时，应该注意到两个基本因素：哈希函数和冲突解决

1. 哈希函数。

哈希函数是哈希表中最重要的组件，该哈希表用于将键映射到特定的桶。在上一篇文章中的示例中，我们使用 y = x % 5 作为散列函数，其中 x 是键值，y 是分配的桶的索引。

散列函数取决与键值的范围和桶的数量。

![](https://aliyun-lc-upload.oss-cn-hangzhou.aliyuncs.com/aliyun-lc-upload/uploads/2018/05/04/screen-shot-2018-05-04-at-145454.png)

哈希函数的设计是一个开放的问题。其思想是尽可能将键分配到桶中，理想情况下，完美的哈希函数将是键和桶之间的一对一映射。然而，在大多数情况下，哈希函数并不完美，它需要在桶的数量和桶的容量之间进行权衡。

2. 冲突解决

理想情况下，如果我们的哈希函数是完美的一对一映射，我们将不需要处理冲突。
不幸的是，在大多数情况下，冲突几乎是不可避免的。
例如，在我们之前的哈希函数（y  =  x ％ 5）中，1987 和 2 都分配给了桶 2，这是一个冲突。

冲突解决算法应该解决以下几个问题：

> 如何组织在同一个桶中的值？  
> 如果为同一个桶分配了太多的值，该怎么办？  
> 如何在特定的桶中搜索目标值？  

根据我们的哈希函数，这些问题与桶的容量和可能映射到同一个桶的键的数目有关。

让我们假设存储最大键数的桶有 N 个键。

通常，如果 N 是常数且很小，我们可以简单地使用一个数组将键存储在同一个桶中。如果 N 是可变的或很大，我们可能需要使用高度平衡的二叉树来代替.。



#### 3. 了解哈希集合与哈希映射之间的区别



#### 4. 如何设计如典型的标准模板库中那样的哈希集合和哈希映射的简化版本。



#### 5. 插入和查找操作的复杂度是什么？


## 场景

### 提供更多信息

使用哈希映射的第一个场景是，我们需要更多的信息，而不仅仅是键。然后通过哈希映射建立密钥与信息之间的映射关系。

#### 示例
让我们来看一个例子：

> 给定一个整数数组，返回两个数字的索引，使它们相加得到特定目标。

在这个例子中，如果我们只想在有解决方案时返回 true，我们可以使用哈希集合来存储迭代数组时的所有值，并检查 target - current_value 是否在哈希集合中。

但是，我们被要求返回更多信息，这意味着我们不仅关心值，还关心索引。我们不仅需要存储数字作为键，还需要存储索引作为值。因此，我们应该使用哈希映射而不是哈希集合。

#### 更重要的是

在某些情况下，我们需要更多信息，不仅要返回更多信息，还要帮助我们做出决策。

在前面的示例中，当我们遇到重复的键时，我们将立即返回相应的信息。但有时，我们可能想先检查键的值是否可以接受。

#### 模板

在这里，我们为您提供了解决此类问题的模板：

```java
/*
 * Template for using hash map to find duplicates.
 * Replace ReturnType with the actual type of your return value.
 */
ReturnType aggregateByKey_hashmap(List<Type>& keys) {
    // Replace Type and InfoType with actual type of your key and value
    Map<Type, InfoType> hashmap = new HashMap<>();
    for (Type key : keys) {
        if (hashmap.containsKey(key)) {
            if (hashmap.get(key) satisfies the requirement) {
                return needed_information;
            }
        }
        // Value can be any information you needed (e.g. index)
        hashmap.put(key, value);    
    }
    return needed_information;
}
```

### 按键聚合

另一个常见的场景是按键聚合所有信息。我们也可以使用哈希映射来实现这一目标。

#### 示例

这是一个例子：

> 给定一个字符串，找到它中的第一个非重复字符并返回它的索引。如果它不存在，则返回 -1。

解决此问题的一种简单方法是首先计算每个字符的出现次数。然后通过结果找出第一个与众不同的角色。

因此，我们可以维护一个哈希映射，其键是字符，而值是相应字符的计数器。每次迭代一个字符时，我们只需将相应的值加 1。

#### 更重要的是

解决此类问题的关键是在遇到现有键时确定策略。
     
在上面的示例中，我们的策略是计算事件的数量。有时，我们可能会将所有值加起来。有时，我们可能会用最新的值替换原始值。策略取决于问题，实践将帮助您做出正确的决定。

#### 模板

在这里，我们为您提供了解决此类问题的模板：

```java
/*
 * Template for using hash map to find duplicates.
 * Replace ReturnType with the actual type of your return value.
 */
ReturnType aggregateByKey_hashmap(List<Type>& keys) {
    // Replace Type and InfoType with actual type of your key and value
    Map<Type, InfoType> hashmap = new HashMap<>();
    for (Type key : keys) {
        if (hashmap.containsKey(key)) {
            hashmap.put(key, updated_information);
        }
        // Value can be any information you needed (e.g. index)
        hashmap.put(key, value);    
    }
    return needed_information;
}
```

## 设计键

在以前的问题中，键的选择相对简单。不幸的是，有时你必须考虑在使用哈希表时设计合适的键。

#### 示例

我们来看一个例子：

> 给定一组字符串，将字母异位词组合在一起。

众所周知，哈希映射可以很好地按键分组信息。但是我们不能直接使用原始字符串作为键。
我们必须设计一个合适的键来呈现字母异位词的类型。
例如，有字符串 “eat” 和 “ate” 应该在同一组中。
但是 “eat” 和 “act” 不应该组合在一起。

#### 解决方案

实际上，设计关键是在原始信息和哈希映射使用的实际键之间建立映射关系。设计键时，需要保证：

> 1. 属于同一组的所有值都将映射到同一组中。
> 2. 需要分成不同组的值不会映射到同一组。

此过程类似于设计哈希函数，但这是一个本质区别。哈希函数满足第一个规则但可能不满足第二个规则。但是你的映射函数应该满足它们。

在上面的示例中，我们的映射策略可以是：对字符串进行排序并使用排序后的字符串作为键。也就是说，“eat” 和 “ate” 都将映射到 “aet”。

有时，设计映射策略可能是非常棘手的。我们将在本章为您提供一些练习，并在此之后给出总结。
