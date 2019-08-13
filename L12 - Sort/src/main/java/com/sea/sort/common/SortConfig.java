package com.sea.sort.common;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScans({ @ComponentScan("com.sea.sort.sorts.BubbleSorts"), @ComponentScan("com.sea.sort.sorts.SelctionSorts"),
        @ComponentScan("com.sea.sort.sorts.InsertionSorts") })
public class SortConfig {

}