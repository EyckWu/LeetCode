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

