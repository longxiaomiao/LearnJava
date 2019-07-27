package demo;

import demo.common.SortData;
import demo.sort.BaseSort;
import demo.sort.BubbleSorts.*;

public class App {
    public static void main(String[] args) {
        SortData.ShowSortData();

        // 冒泡排序
        BaseSort bubbleSort = new BubbleSort();
        bubbleSort.Show(SortData.GetSortData());

        // 冒泡排序（倒序）
        BaseSort bubbleSortDesc = new BubbleSortDesc();
        bubbleSortDesc.Show(SortData.GetSortData());

        // 冒泡排序（从右往左冒泡）
        BaseSort bubbleSortReverse = new BubbleSortReverse();
        bubbleSortReverse.Show(SortData.GetSortData());

        // 冒泡排序（从右往左冒泡 - 倒序）
        BaseSort bubbleSortReverseDesc = new BubbleSortReverseDesc();
        bubbleSortReverseDesc.Show(SortData.GetSortData());
    }
}
