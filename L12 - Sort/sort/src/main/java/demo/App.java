package demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import demo.common.SortConfig;
import demo.common.SortData;
import demo.sort.BaseSort;

public class App {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SortConfig.class);
        SortData.ShowSortData();
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            Object obj = context.getBean(name);
            if (obj.getClass().getGenericSuperclass().equals(BaseSort.class))
                ((BaseSort) obj).Show(SortData.GetSortData());
        }
        context.close();
    }
}
