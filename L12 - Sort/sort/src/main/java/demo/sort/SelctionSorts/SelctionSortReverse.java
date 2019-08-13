package demo.sort.SelctionSorts;

import java.util.List;

import org.springframework.stereotype.Component;

import demo.sort.BaseSort;

/**
 * 选择排序（反向）
 */
@Component
public class SelctionSortReverse extends BaseSort {

    public SelctionSortReverse() {
        super("选择排序（反向）");
    }

    @Override
    public List<Integer> Run(List<Integer> list) {
        int temp;
        int size = list.size();
        for (int i = size - 1; i > 0; i--) {
            int maxIndex = i;
            for (int j = 0; j < i; j++) {
                if (list.get(j) > list.get(maxIndex)) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                temp = list.get(maxIndex);
                list.set(maxIndex, list.get(i));
                list.set(i, temp);
            }
        }
        return list;
    }

}