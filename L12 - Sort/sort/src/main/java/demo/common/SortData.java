package demo.common;

import java.util.ArrayList;
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
        return list;
    }

    public static void ShowSortData() {
        System.out.println("排序前：");
        ShowList(GetSortData());
    }

    public static void ShowList(List<Integer> list) {
        for (int i : list) {
            System.out.print(i + " ");
        }
    }
}