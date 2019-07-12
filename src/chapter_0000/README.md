## 十大经典排序算法

#### 1 算法分类

> 比较类算法：通过比较来决定元素间的相对次序，由于其时间复杂度不能突破O(nlogn)，因此也称为非线性时间比较类排序。

> 非比较类排序：不通过比较来决定元素间的相对次序，它可以突破基于比较排序的时间下界，以线性时间运行，因此也称为线性时间非比较类排序。 

![](https://ws1.sinaimg.cn/large/6b0d07d7gy1g49p6mwcgpj21240uan0x.jpg)

#### 2 算法复杂度

排序算法可以分为**内部排序**和**外部排序**

> 内部排序: 数据记录在内存中进行排序。

> 外部排序: 因排序的数据很大，一次不能容纳全部的排序记录，在排序过程中需要访问外存。

![](https://ws1.sinaimg.cn/large/6b0d07d7gy1g49p9csvm4j20qu0gcgmv.jpg)

#### 3 相关概念

> 稳定性: 如果a原本在b之前，而a=b，排序后a仍然在b的前面，则为稳定，反之为不稳定。

> 时间复杂度: 对排序数据总的操作次数。

> 空间复杂度: 在计算机内执行时所需要的内存空间的度量。

### 1 冒泡排序(Bubble Sort)

冒泡排序是一种简单的排序算法。它重复地走访过要排序地数列，依次比较两个元素，如果它们地顺序错误就把它们交换过来。走访数列地工作是重复地进行直到没有再进行交换，也就是说该数列已经排序完成。

1.1 算法描述

> 比较相邻地元素。如果第一个比第二个大，就交换它们两个；  
> 对每一项相邻元素作同样地工作，从开始第一对到结尾地最后一对，这样在最后的元素应该会是最大的数；  
> 针对所有的元素重复以上的步骤，除了最后一个；  
> 重复步骤 1~3，直至排序完成。  

1.2 动画演示

![](https://ws1.sinaimg.cn/large/6b0d07d7gy1g49prt5oaig20my075wqv.gif)

1.3 代码实现

```
public class BubbleSort implements ISortArray{

    @Override
    public int[] sort(int[] sourceArray) {
        int length = sourceArray.length;
        for (int i = 0; i < length - 1; i++){
            for (int j = 0; j < length - 1 - i; j++){
                if (sourceArray[j] > sourceArray[j+1]){
                    int temp = sourceArray[j+1];
                    sourceArray[j+1] = sourceArray[j];
                    sourceArray[j] = temp;
                }
            }
        }
        return sourceArray;
    }
}
```


### 2 选择排序(Selection Sort)

选择排序是一种简单直观的排序算法。它的工作原理：首先在未排序的序列中找到最小(大)元素，存放在排序序列的起始位置，然后再从剩余未排序元素中继续寻找最小(大)元素，然后放到已排序序列的末尾，以此类推，直到所有元素均排序完毕。

2.1 算法描述

n 个记录的直接选择排序可经过 n-1 趟直接选择排序得到有序的结果。具体算法描述如下：

> 初始状态：无序区为R[1..n], 有序区为空；  
> 第i趟排序(i=1,2,3...n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R[i..n]。该趟排序从当前无序区中选出关键字最小的序列R[k]，将它与无序区的第一个记录R交换，使R[1..i]和R[i+i..n]分别变为记录个数增加1个的新的有序区和记录个数减少1个的新有序区；  
> n-1 趟结束，数组有序化了。  

2.2 动画演示

![](https://ws1.sinaimg.cn/large/6b0d07d7gy1g49prt5oaig20my075wqv.gif)

2.3 代码实现

```
public class SelectionSort implements ISortArray{
    @Override
    public int[] sort(int[] sourceArray) {
        int length = sourceArray.length;
        for (int i = 0; i < length; i++){
            int index = i;
            for (int j = i; j < length; j++){
                if (sourceArray[j] < sourceArray[index]){
                    index = j;
                }
            }
            if (sourceArray[index] < sourceArray[i]){
                int temp = sourceArray[index];
                sourceArray[index] = sourceArray[i];
                sourceArray[i] = temp;
            }
        }
        return sourceArray;
    }
}
```

### 3 插入排序(Insertion Sort)

插入排序（Insertion-Sort）的算法描述是一种简单直观的排序算法。它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。

3.1 算法描述

一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：

- 从第一个元素开始，该元素可以认为已经被排序；
- 取出下一个元素，在已经排序的元素序列中从后向前扫描；
- 如果该元素（已排序）大于新元素，将该元素移到下一位置；
- 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
- 将新元素插入到该位置后；
- 重复步骤2~5。

3.2 动画演示

![](http://ww1.sinaimg.cn/large/6b0d07d7gy1g4xi1oxp23g20mj0e113f.gif)

3.3 代码实现








