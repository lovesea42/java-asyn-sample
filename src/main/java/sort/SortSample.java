package sort;

import java.util.Arrays;

/**
 * Created by wangyijie on 2017/6/29.
 */
public class SortSample {


    //冒泡排序

    /**
     * 冒泡排序是一种极其简单的排序算法，也是我所学的第一个排序算法。它重复地走访过要排序的元素，一次比较相邻两个元素，如果他们的顺序错误就把他们调换过来，直到没有元素再需要交换，排序完成。这个算法的名字由来是因为越小(或越大)的元素会经由交换慢慢“浮”到数列的顶端。

     　　冒泡排序算法的运作如下：

     比较相邻的元素，如果前一个比后一个大，就把它们两个调换位置。
     对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
     针对所有的元素重复以上的步骤，除了最后一个。
     持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     */
    public static int[] BubleSort(int[] src){
        for(int i = 0;i < src.length;i++){
            for(int j = i+1;j < src.length;j++){
                if(src[i] > src[j]){
                    int temp = src[i];
                    src[i] = src[j];
                    src[j] = temp;
                }
            }
        }


        return src;
    }

    /*
    * 选择排序也是一种简单直观的排序算法。它的工作原理很容易理解：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置；然后，
    * 再从剩余未排序元素中继续寻找最小（大）元素，放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。*/

    public static int[] SelectionSort(int[] src){
        int index;
        for(int i = 0;i < src.length;i++){
            index = i;
            for(int j = i+1;j < src.length;j++){
                if(src[index] > src[j]){
                    index = j;
                }
            }

            int temp = src[i];
            src[i] = src[index];
            src[index] = temp;
        }


        return src;
    }

    /**
     对于未排序数据(右手抓到的牌)，在已排序序列(左手已经排好序的手牌)中从后向前扫描，找到相应位置并插入。

     　　插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。

     　　具体算法描述如下：

     从第一个元素开始，该元素可以认为已经被排序
     取出下一个元素，在已经排序的元素序列中从后向前扫描
     如果该元素（已排序）大于新元素，将该元素移到下一位置
     重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
     将新元素插入到该位置后
     重复步骤2~5
     */
    public static int[] InsertionSort(int[] src){
        int get;
        for(int i = 1;i < src.length;i++){
            get = src[i];
            int j = i - 1;
            while(j >= 0 && src[j] > get){
                src[j+1] = src[j];
                j--;
            }
            src[j+1] = get;
        }


        return src;
    }

    public static void main(String[] args) {

        int src[] = { 6, 5, 3, 1, 8, 7, 2, 4 };

        int des[] = BubleSort(src);
        System.out.println(Arrays.toString(des));
        des = SelectionSort(src);
        System.out.println(Arrays.toString(des));
        des = InsertionSort(src);
        System.out.println(Arrays.toString(des));
    }
}
