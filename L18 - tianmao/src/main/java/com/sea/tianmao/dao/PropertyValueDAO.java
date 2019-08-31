package com.sea.tianmao.dao;

import com.sea.tianmao.pojo.Product;
import com.sea.tianmao.pojo.Property;
import com.sea.tianmao.pojo.PropertyValue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyValueDAO extends JpaRepository<PropertyValue, Integer> {
    List<PropertyValue> findByProductOrderByIdDesc(Product product);

    PropertyValue findByProductAndProperty(Product product, Property property);
}
