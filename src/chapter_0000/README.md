## 十大经典排序算法

#### 1 算法分类

- 比较类算法：通过比较来决定元素间的相对次序，由于其时间复杂度不能突破O(nlogn)，因此也称为非线性时间比较类排序。

- 非比较类排序：不通过比较来决定元素间的相对次序，它可以突破基于比较排序的时间下界，以线性时间运行，因此也称为线性时间非比较类排序。 

![](https://ws1.sinaimg.cn/large/6b0d07d7gy1g49p6mwcgpj21240uan0x.jpg)

#### 2 算法复杂度

排序算法可以分为**内部排序**和**外部排序**

- 内部排序: 数据记录在内存中进行排序。

- 外部排序: 因排序的数据很大，一次不能容纳全部的排序记录，在排序过程中需要访问外存。

![](https://ws1.sinaimg.cn/large/6b0d07d7gy1g49p9csvm4j20qu0gcgmv.jpg)

#### 3 相关概念

- 稳定性: 如果a原本在b之前，而a=b，排序后a仍然在b的前面，则为稳定，反之为不稳定。

- 时间复杂度: 对排序数据总的操作次数。

- 空间复杂度: 在计算机内执行时所需要的内存空间的度量。

### 1 冒泡排序(Bubble Sort)

冒泡排序是一种简单的排序算法。它重复地走访过要排序地数列，依次比较两个元素，如果它们地顺序错误就把它们交换过来。走访数列地工作是重复地进行直到没有再进行交换，也就是说该数列已经排序完成。

1.1 算法描述

- 比较相邻地元素。如果第一个比第二个大，就交换它们两个；  
- 对每一项相邻元素作同样地工作，从开始第一对到结尾地最后一对，这样在最后的元素应该会是最大的数；  
- 针对所有的元素重复以上的步骤，除了最后一个；  
- 重复步骤 1~3，直至排序完成。  

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

- 初始状态：无序区为R[1..n], 有序区为空；  
- 第i趟排序(i=1,2,3...n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R[i..n]。该趟排序从当前无序区中选出关键字最小的序列R[k]，将它与无序区的第一个记录R交换，使R[1..i]和R[i+i..n]分别变为记录个数增加1个的新的有序区和记录个数减少1个的新有序区；  
- n-1 趟结束，数组有序化了。  

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

![](http://ws1.sinaimg.cn/large/6b0d07d7gy1g4xi1oxp23g20mj0e113f.gif)

3.3 代码实现

```
public class InsertionSort implements ISortArray {
    @Override
    public int[] sort(int[] sourceArray) {
        for (int i = 1; i < sourceArray.length; i++){
            int j = i - 1;
            int temp = sourceArray[i];
            while (j >= 0 && sourceArray[j] > temp){
                sourceArray[j+1] = sourceArray[j];
                j--;
            }
            sourceArray[j+1] = temp;
        }
        return sourceArray;
    }
}
```

### 4 希尔排序

1959年Shell发明，第一个突破O(n2)的排序算法，是简单插入排序的改进版。它与插入排序的不同之处在于，它会优先比较距离较远的元素。希尔排序又叫缩小增量排序。。

4.1 算法描述

先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，具体算法描述：

- 选择一个增量序列t1，t2，…，tk，其中ti-tj，tk=1；
- 按增量序列个数k，对序列进行k 趟排序；
- 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。

4.2 动画演示

![](https://ws1.sinaimg.cn/large/6b0d07d7gy1g4xxhake3xg20qi0exkc0.gif)

4.3 代码实现

```
public class ShellSort implements ISortArray {
    @Override
    public int[] sort(int[] sourceArray) {
        int gap = 1;
        while(gap < sourceArray.length){
            gap = gap * 3 + 1;
        }
        while(gap > 0){
            for (int i = gap; i < sourceArray.length; i++){
                int tmp = sourceArray[i];
                int j = i - gap;
                while (j >= 0 && sourceArray[j] > tmp){
                    sourceArray[j + gap] = sourceArray[j];
                    j -= gap;
                }
                sourceArray[j + gap] = tmp;
            }
            gap = (int)Math.floor(gap / 3);
        }
        return sourceArray;
    }
}
```

### 5 归并排序(Merge Sort)

归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。 

5.1 算法描述

- 把长度为n的输入序列分成两个长度为n/2的子序列；
- 对这两个子序列分别采用归并排序；
- 将两个排序好的子序列合并成一个最终的排序序列。


5.2 动画演示

![](https://ws1.sinaimg.cn/large/6b0d07d7gy1g4xy2htiftg20qi0exx1i.gif)


5.3 代码实现

```
public class MergeSort implements ISortArray {
    @Override
    public int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        if (arr.length < 2){
            return arr;
        }
        int middle = (int)Math.floor(arr.length / 2);

        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);
        return merge(sort(left), sort(right));
    }

    protected int[] merge(int[] left, int[] right){
        int[] result = new int[left.length + right.length];
        int i = 0;
        while(left.length > 0 && right.length > 0){
            if (left[0] <= right[0]){
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }
        while (left.length > 0){
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }

        while (right.length > 0){
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }
        return result;
    }
}
```

### 6 快速排序(Quick Sort)

快速排序的基本思想：通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序。

6.1 算法描述

快速排序使用分治法来把一个串（list）分为两个子串（sub-lists）。具体算法描述如下：

- 从数列中挑出一个元素，称为 “基准”（pivot）；
- 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
- 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。

6.2 动画演示

![](https://ws1.sinaimg.cn/large/6b0d07d7gy1g4xz80qnf3g20qi0extsn.gif)

6.3 代码实现

```
public class QuickSort implements ISortArray {
    @Override
    public int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        return quickSort(arr, 0, arr.length - 1);
    }

    private int[] quickSort(int[] arr, int left, int right){
        if (left < right){
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    private int partition(int[] arr, int left, int right){
        // 设置基准值(pivot)
        int pivot = left;
        int index = left + 1;
        for (int i = index; i <=right; i++){
            if (arr[i] < arr[pivot]){
                swap(arr, i , index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private void swap(int[] arr, int i, int index) {
        System.out.println("arr[i] = " + arr[i] + ";arr[index] = " + arr[index]);
        int tmp = arr[i];
        arr[i] = arr[index];
        arr[index] = tmp;
    }
}
```

### 8 计数排序(Count Sort)

计数排序不是基于比较的排序算法，其核心在于将输入的数据值转化为键存储在额外开辟的数组空间中。 作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数。

8.1 算法描述

- 找出待排序的数组中最大和最小的元素；
- 统计数组中每个值为i的元素出现的次数，存入数组C的第i项；
- 对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）；
- 反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1。

8.2 动画演示

![](http://ww1.sinaimg.cn/large/6b0d07d7gy1g4yjcb8qmfg20s40fhdmw.gif)

8.3 代码实现

```
public class CountSort implements ISortArray {
    @Override
    public int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int maxValue = getMaxValue(arr);
        int[] bucket = new int[maxValue + 1];
        for (int i = 0; i < arr.length; i++){
            bucket[arr[i]]++;
        }
        System.out.println("bucket = " + Arrays.toString(bucket));
        int sortIndex = 0;
        for (int i = 0; i < bucket.length; i++){
            while (bucket[i] > 0) {
                arr[sortIndex++] = i;
                bucket[i]--; 
            }
        }
        return arr;
    }

    private int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (maxValue < arr[i]){
                maxValue = arr[i];
            }
        }
        return maxValue;
    }
}
```

### 9 桶排序(Bucket Sort)

桶排序是计数排序的升级版。它利用了函数的映射关系，高效与否的关键就在于这个映射函数的确定。桶排序 (Bucket sort)的工作的原理：假设输入数据服从均匀分布，将数据分到有限数量的桶里，每个桶再分别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排）。

9.1 算法描述

- 设置一个定量的数组当作空桶；
- 遍历输入数据，并且把数据一个一个放到对应的桶里去；
- 对每个不是空的桶进行排序；
- 从不是空的桶里把排好序的数据拼接起来。 

9.2 动画演示

![](http://ww1.sinaimg.cn/large/6b0d07d7gy1g4z6yj645ng20qi0exhdt.gif)

9.3 代码实现

```
public class BucketSort implements ISortArray {
    @Override
    public int[] sort(int[] sourceArray) {
        if (sourceArray.length <= 1){
            return sourceArray;
        }
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int bucketSize = 5;
        int maxValue = arr[0];
        int minValue = arr[0];
        for (int i = 0; i < arr.length; i++){
            if (maxValue < arr[i]){
                maxValue = arr[i];
            } else if (minValue > arr[i]){
                minValue = arr[i];
            }
        }
        int bucketCount = (int)Math.floor((maxValue - minValue) / bucketSize) + 1;
        int[][] buckets = new int[bucketCount][0];
        // 利用映射函数分配到各个桶中
        for (int i = 0; i < arr.length; i++){
            int index = (int)Math.floor((arr[i] - minValue) / bucketSize);
            buckets[index] = arrAppend(buckets[index], arr[i]);
        }
        int arrIndex = 0;
        ISortArray insertionSort = new InsertionSort();
        for (int[] bucket: buckets){
            if (bucket.length <= 0){
                continue;
            }
            bucket = insertionSort.sort(bucket);
            for (int value: bucket){
                arr[arrIndex++] = value;
            }
        }
        return arr;
    }

    private int[] arrAppend(int[] bucket, int ivalue) {
        bucket = Arrays.copyOf(bucket, bucket.length + 1);
        bucket[bucket.length - 1] = ivalue;
        return bucket;
    }
}
```

### 10 基数排序

基数排序是按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。有时候有些属性是有优先级顺序的，先按低优先级排序，再按高优先级排序。最后的次序就是高优先级高的在前，高优先级相同的低优先级高的在前。

10.1 算法描述

- 取得数组中的最大数，并取得位数；
- arr为原始数组，从最低位开始取每个位组成radix数组；
- 对radix进行计数排序（利用计数排序适用于小范围数的特点）；

10.2 动图演示

![](http://ww1.sinaimg.cn/large/6b0d07d7gy1g4zcs6go12g20s40fydky.gif)

10.3 代码实现

```
public class RadixSort implements ISortArray {
    @Override
    public int[] sort(int[] sourceArray) {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int maxDigit = getMaxDigit(arr);
        return radixSort(arr, maxDigit);
    }

    /**
     * 获取最高位数
     */
    private int getMaxDigit(int[] arr) {
        int maxValue = getMaxValue(arr);
        return getNumLenght(maxValue);
    }

    private int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int value : arr) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        return maxValue;
    }


    protected int getNumLenght(long num) {
        if (num == 0) {
            return 1;
        }
        int lenght = 0;
        for (long temp = num; temp != 0; temp /= 10) {
            lenght++;
        }
        return lenght;
    }


    private int[] radixSort(int[] arr, int maxDigit) {
        int mod = 10;
        int dev = 1;
        for (int i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
            // 考虑负数的情况，这里扩展一倍队列数，其中 [0-9]对应负数，[10-19]对应正数 (bucket + 10)
            int[][] counter = new int[mod * 2][0];
            for (int j = 0; j < arr.length; j++) {
                int bucket = ((arr[j] % mod) / dev) + mod;
                counter[bucket] = arrayAppend(counter[bucket], arr[j]);

            }
            int pos = 0;
            for (int[] bucket : counter) {
                for (int value : bucket) {
                    arr[pos++] = value;
                }
            }
        }
        return arr;
    }

    private int[] arrayAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;

    }
}
```