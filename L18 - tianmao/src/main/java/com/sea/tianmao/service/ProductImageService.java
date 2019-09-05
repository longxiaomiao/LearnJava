package com.sea.tianmao.service;

import com.sea.tianmao.dao.ProductDAO;
import com.sea.tianmao.dao.ProductImageDAO;
import com.sea.tianmao.pojo.OrderItem;
import com.sea.tianmao.pojo.Product;
import com.sea.tianmao.pojo.ProductImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImageService {
    public static final String TYPE_SINGLE = "single";
    public static final String TYPE_DETAIL = "detail";

    @Autowired
    ProductImageDAO productImageDAO;
    @Autowired
    ProductService productService;

    public List<ProductImage> listSingleProductImages(Product product) {
        return productImageDAO.findByProductAndTypeOrderByIdDesc(product, TYPE_SINGLE);
    }

    public List<ProductImage> listDetailProductImages(Product product) {
        return productImageDAO.findByProductAndTypeOrderByIdDesc(product, TYPE_DETAIL);
    }

    public void setFirstProductImage(Product product) {
        List<ProductImage> singleImages = listSingleProductImages(product);
        if (!singleImages.isEmpty())
            product.setFirstProductImage(singleImages.get(0));
        else
            product.setFirstProductImage(new ProductImage());
    }

    public void setFirstProductImages(List<Product> products) {
        for (Product product : products) {
            setFirstProductImage(product);
        }
    }

    public void add(ProductImage productImage) {
        productImageDAO.save(productImage);
    }

    public void delete(int id) {
        productImageDAO.deleteById(id);
    }

    public void setFirstProdutImagesOnOrderItems(List<OrderItem> ois) {
        for (OrderItem orderItem : ois) {
            setFirstProductImage(orderItem.getProduct());
        }
    }
}
