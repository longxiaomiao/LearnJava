package com.sea.sort.sorts.SelctionSorts;

import java.util.List;

import com.sea.sort.sorts.BaseSort;
import org.springframework.stereotype.Component;


/**
 * 选择排序（倒序）
 */
@Component
public class SelctionSortDesc extends BaseSort {
    public SelctionSortDesc() {
        super("选择排序（倒序）");
    }

    @Override
    public List<Integer> Run(List<Integer> list) {
        int temp;
        int size = list.size();

        for (int i = 0; i < size - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (list.get(j) > list.get(maxIndex)) {
                    maxIndex = j;
                }
            }
            if (maxIndex != 0) {
                temp = list.get(maxIndex);
                list.set(maxIndex, list.get(i));
                list.set(i, temp);
            }
        }
        return list;
    }

}