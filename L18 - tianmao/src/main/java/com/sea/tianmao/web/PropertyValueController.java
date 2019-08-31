package com.sea.tianmao.web;

import com.sea.tianmao.pojo.Product;
import com.sea.tianmao.pojo.Property;
import com.sea.tianmao.pojo.PropertyValue;
import com.sea.tianmao.service.ProductService;
import com.sea.tianmao.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PropertyValueController {
    @Autowired
    PropertyValueService propertyValueService;
    @Autowired
    ProductService productService;

    @GetMapping("/products/{pid}/propertyValues")
    public List<PropertyValue> list(@PathVariable("pid") int pid) throws Exception {
        Product product = productService.get(pid);
        propertyValueService.init(product);
        List<PropertyValue> propertyValues = propertyValueService.list(product);
        return propertyValues;
    }

    @PutMapping("/propertyValues")
    public Object update(@RequestBody PropertyValue propertyValue) throws Exception {
        propertyValueService.update(propertyValue);
        return propertyValue;
    }
}
