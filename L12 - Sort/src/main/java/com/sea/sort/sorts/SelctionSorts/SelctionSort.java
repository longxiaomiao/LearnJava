package com.sea.sort.sorts.SelctionSorts;

import java.util.List;

import com.sea.sort.sorts.BaseSort;
import org.springframework.stereotype.Component;


/**
 * 选择排序
 */
@Component
public class SelctionSort extends BaseSort {
    public SelctionSort() {
        super("选择排序");
    }

    @Override
    public List<Integer> Run(List<Integer> list) {
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (list.get(j) < list.get(minIndex)) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = list.get(i);
                list.set(i, list.get(minIndex));
                list.set(minIndex, temp);
            }
        }
        return list;
    }
    
}