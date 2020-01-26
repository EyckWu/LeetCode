##  简介 - 双链表

### 定义 

双链表以类似的方式工作，但还有一个引用字段，称为“prev”字段。有了这个额外的字段，您就能够知道当前结点的前一个结点。

让我们看一个例子：

![双链表](https://aliyun-lc-upload.oss-cn-hangzhou.aliyuncs.com/aliyun-lc-upload/uploads/2018/04/17/screen-shot-2018-04-17-at-161130.png)

绿色箭头表示我们的“prev”字段是如何工作的。

绿色箭头表示我们的“prev”字段是如何工作的。

### 节点结构

```java
// Definition for doubly-linked list.
class DoublyListNode {
    int val;
    DoublyListNode next, prev;
    DoublyListNode(int x) {val = x;}
}
```

与单链接列表类似，我们将使用头结点来表示整个列表。

### 操作

与单链表类似，我们将介绍在双链表中如何访问数据、插入新结点或删除现有结点。

我们可以与单链表相同的方式访问数据：

> 我们不能在常量级的时间内访问随机位置。  
> 我们必须从头部遍历才能得到我们想要的第一个结点。  
> 在最坏的情况下，时间复杂度将是 O(N)，其中 N 是链表的长度。  

对于添加和删除，会稍微复杂一些，因为我们还需要处理“prev”字段。在接下来的两篇文章中，我们将介绍这两个操作

之后，我们提供练习，让你使用双链表重新设计链表。

## 添加操作 - 双链表

如果我们想在现有的结点 prev 之后插入一个新的结点 cur，我们可以将此过程分为两个步骤：

> 1.链接 cur 与 prev 和 next，其中 next 是 prev 原始的下一个节点；

![1](https://aliyun-lc-upload.oss-cn-hangzhou.aliyuncs.com/aliyun-lc-upload/uploads/2018/04/28/screen-shot-2018-04-28-at-173045.png)

> 2.用 cur 重新链接 prev 和 next。

![2](https://aliyun-lc-upload.oss-cn-hangzhou.aliyuncs.com/aliyun-lc-upload/uploads/2018/04/29/screen-shot-2018-04-28-at-173055.png)

与单链表类似，添加操作的时间和空间复杂度都是 O(1)。

## 删除操作 - 双链表

如果我们想从双链表中删除一个现有的结点 cur，我们可以简单地将它的前一个结点 prev 与下一个结点 next 链接起来。

与单链表不同，使用“prev”字段可以很容易地在常量时间内获得前一个结点。

因为我们不再需要遍历链表来获取前一个结点，所以时间和空间复杂度都是O(1)。

