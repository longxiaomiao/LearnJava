package com.sea.tianmao.service;

import com.sea.tianmao.dao.PropertyValueDAO;
import com.sea.tianmao.pojo.Product;
import com.sea.tianmao.pojo.Property;
import com.sea.tianmao.pojo.PropertyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyValueService {
    @Autowired
    PropertyValueDAO propertyValueDAO;
    @Autowired
    PropertyService propertyService;

    public void init(Product product) {
        List<Property> properties = propertyService.list(product.getCategory());
        for (Property property : properties) {
            PropertyValue propertyValue = propertyValueDAO.findByProductAndProperty(product, property);
            if (null == propertyValue) {
                propertyValue = new PropertyValue();
                propertyValue.setProduct(product);
                propertyValue.setProperty(property);
                propertyValueDAO.save(propertyValue);
            }
        }
    }

    public List<PropertyValue> list(Product product) {
        return propertyValueDAO.findByProductOrderByIdDesc(product);
    }

    public void update(PropertyValue propertyValue) {
        propertyValueDAO.save(propertyValue);
    }
}
