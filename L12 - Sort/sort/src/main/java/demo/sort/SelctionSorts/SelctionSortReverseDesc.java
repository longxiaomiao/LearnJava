package demo.sort.SelctionSorts;

import java.util.List;

import org.springframework.stereotype.Component;

import demo.sort.BaseSort;

/**
 * 选择排序（反向倒序）
 */
@Component
public class SelctionSortReverseDesc extends BaseSort {
    public SelctionSortReverseDesc() {
        super("选择排序（反向倒序）");
    }

    @Override
    public List<Integer> Run(List<Integer> list) {
        int temp;
        int size = list.size();

        for (int i = size - 1; i > 0; i--) {
            int minIndex = i;
            for (int j = 0; j < i; j++) {
                if (list.get(j) < list.get(minIndex)) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                temp = list.get(minIndex);
                list.set(minIndex, list.get(i));
                list.set(i, temp);
            }
        }
        return list;
    }

}