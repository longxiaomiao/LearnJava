package demo.common;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScans({ @ComponentScan("demo.sort.BubbleSorts"), @ComponentScan("demo.sort.SelctionSorts"),
        @ComponentScan("demo.sort.InsertionSorts") })
public class SortConfig {

}