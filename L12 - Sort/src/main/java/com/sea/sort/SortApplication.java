package com.sea.sort;

import com.sea.sort.common.SortConfig;
import com.sea.sort.common.SortData;
import com.sea.sort.sorts.BaseSort;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

@SpringBootApplication
public class SortApplication {

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
