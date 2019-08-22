package com.sea.tianmao.service;

import com.sea.tianmao.dao.CategoryDAO;
import com.sea.tianmao.dao.PropertyDAO;
import com.sea.tianmao.pojo.Category;
import com.sea.tianmao.pojo.Property;
import com.sea.tianmao.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PropertyService {
    @Autowired
    PropertyDAO propertyDAO;
    @Autowired
    CategoryService categoryService;

    public void add(Property property) {
        propertyDAO.save(property);
    }

    public void delete(int id) {
//        throw new Exception("123");
        propertyDAO.deleteById(id);
    }

    public Property get(int id) {
        return propertyDAO.getOne(id);
    }

    public void update(Property property) {
        propertyDAO.save(property);
    }

    public Page4Navigator<Property> list(int cid, int start, int size, int navigatePages) {
        Category category = categoryService.get(cid);
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(start, size, sort);
        Page<Property> page = propertyDAO.findByCategory(category, pageable);
        return new Page4Navigator<>(page, navigatePages);
    }
}
