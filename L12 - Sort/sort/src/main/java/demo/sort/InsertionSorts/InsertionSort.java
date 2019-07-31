package demo.sort.InsertionSorts;

import java.util.List;

import org.springframework.stereotype.Component;

import demo.sort.BaseSort;

/**
 * 插入排序
 */
@Component
public class InsertionSort extends BaseSort {
    public InsertionSort() {
        super("插入排序");
    }

    @Override
    public List<Integer> Run(List<Integer> list) {
        int temp;
        int size = list.size();
        int insertionIndex;
        for (int i = 1; i < size; i++) {
            insertionIndex = i;
            temp = list.get(insertionIndex);
            while (insertionIndex > 0 && temp < list.get(insertionIndex - 1)) {
                list.set(insertionIndex, list.get(insertionIndex-1));
                insertionIndex--;
            }
            list.set(insertionIndex, temp);
        }
        return list;
    }

}