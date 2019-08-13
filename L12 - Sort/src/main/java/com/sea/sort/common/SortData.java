package com.sea.sort.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortData {
    public static List<Integer> GetSortData() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(4);
        list.add(7);
        list.add(0);
        list.add(4);
        list.add(2);
        list.add(8);
        list.add(5);
        list.add(6);
        list.add(12);
        list.add(23);
        list.add(17);
        list.add(11);
        return list;
    }

    public static void ShowSortData() {
        System.out.println("排序前：");
        ShowList(GetSortData());
    }

    public static void ShowList(List<Integer> list) {
        System.out.println(Arrays.toString(list.toArray()));
    }
}