package demo.sort;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseSort {
    private String Name;

    public abstract List<Integer> Run(List<Integer> list);

    /**
     * 显示排序结果
     */
    public void Show(List<Integer> list) {
        System.out.println();
        System.out.println(Name + "：");
        List<Integer> result = Run(list);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}