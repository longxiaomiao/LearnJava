package com.sea.tianmao.dao;

import com.sea.tianmao.pojo.Order;
import com.sea.tianmao.pojo.OrderItem;
import com.sea.tianmao.pojo.Product;
import com.sea.tianmao.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemDAO extends JpaRepository<OrderItem, Integer> {
    List<OrderItem> findByOrderOrderByIdDesc(Order order);

    List<OrderItem> findByProduct(Product product);

    List<OrderItem> findByUserAndOrderIsNull(User user);
}
