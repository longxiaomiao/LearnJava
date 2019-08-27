package com.sea.tianmao.service;

import com.sea.tianmao.dao.ProductDAO;
import com.sea.tianmao.pojo.Category;
import com.sea.tianmao.pojo.Product;
import com.sea.tianmao.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductDAO productDAO;
    @Autowired
    CategoryService categoryService;

    public Page4Navigator<Product> list(int cid, int start, int size, int navigatePages) {
        Category category = categoryService.get(cid);
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(start, size, sort);
        Page<Product> page = productDAO.findByCategory(category, pageable);
        return new Page4Navigator<Product>(page, navigatePages);
    }

    public void delete(int id) {
        productDAO.deleteById(id);
    }

    public void add(Product product) {
        productDAO.save(product);
    }

    public Product get(int id) {
        return productDAO.getOne(id);
    }

    public void update(Product product) {
        productDAO.save(product);
    }
}
