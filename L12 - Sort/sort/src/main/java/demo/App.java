package demo;

import demo.common.SortData;
import demo.sort.BaseSort;
import demo.sort.BubbleSorts.*;
import demo.sort.SelctionSorts.*;

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

        //选择排序
        BaseSort selctionSort = new SelctionSort();
        selctionSort.Show(SortData.GetSortData());

        //选择排序（倒序）
        BaseSort selctionSortDesc = new SelctionSortDesc();
        selctionSortDesc.Show(SortData.GetSortData());

        //选择排序（反向）
        BaseSort selctionSortReverse = new SelctionSortReverse();
        selctionSortReverse.Show(SortData.GetSortData());
        
        //选择排序（反向倒序）
        BaseSort selctionSortReverseDesc = new SelctionSortReverseDesc();
        selctionSortReverseDesc.Show(SortData.GetSortData());
    }
}
