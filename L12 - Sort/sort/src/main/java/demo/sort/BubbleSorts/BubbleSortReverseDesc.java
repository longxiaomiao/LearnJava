package demo.sort.BubbleSorts;

import java.util.List;

import org.springframework.stereotype.Component;

import demo.sort.BaseSort;

/**
 * 冒泡排序（从右往左冒泡 - 倒序）
 */
@Component
public class BubbleSortReverseDesc extends BaseSort {
    public BubbleSortReverseDesc() {
        super("冒泡排序（从右往左冒泡 - 倒序）");
    }

    @Override
    public List<Integer> Run(List<Integer> list) {
        int temp;
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = size - 1; j > i; j--) {
                if (list.get(j) > list.get(j - 1)) {
                    temp = list.get(j);
                    list.set(j, list.get(j - 1));
                    list.set(j - 1, temp);
                }
            }
        }
        return list;
    }
}