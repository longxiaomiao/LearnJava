package demo.sort;

import java.util.Arrays;
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
        List<Integer> result = Run(list);
        System.out.println(Name + "：\r\n" + Arrays.toString(result.toArray()));
    }
}