package com.sea.tianmao.service;

import com.sea.tianmao.dao.ProductDAO;
import com.sea.tianmao.dao.ReviewDao;
import com.sea.tianmao.pojo.Product;
import com.sea.tianmao.pojo.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    ReviewDao reviewDao;

    public void add(Review review) {
        reviewDao.save(review);
    }

    public List<Review> list(Product product) {
        return reviewDao.findByProductOrderByIdDesc(product);
    }

    public int getCount(Product product) {
        return reviewDao.countByProduct(product);
    }
}
