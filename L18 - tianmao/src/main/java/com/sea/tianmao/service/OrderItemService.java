package com.sea.tianmao.service;

import com.sea.tianmao.dao.OrderDAO;
import com.sea.tianmao.dao.OrderItemDAO;
import com.sea.tianmao.pojo.Order;
import com.sea.tianmao.pojo.OrderItem;
import com.sea.tianmao.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {
    @Autowired
    OrderItemDAO orderItemDAO;
    @Autowired
    ProductImageService productImageService;

    public void fill(Order order) {
        List<OrderItem> orderItems = orderItemDAO.findByOrderOrderByIdDesc(order);
        float total = 0;
        int totalNumber = 0;
        for (OrderItem orderItem : orderItems) {
            total += orderItem.getNumber() * orderItem.getProduct().getPromotePrice();
            totalNumber += orderItem.getNumber();
            productImageService.setFirstProductImage(orderItem.getProduct());
        }
        order.setTotal(total);
        order.setTotalNumber(totalNumber);
        order.setOrderItems(orderItems);
    }

    public void fill(List<Order> orders) {
        for (Order order : orders)
            fill(order);
    }

    public List<OrderItem> listByOrder(Order order) {
        return orderItemDAO.findByOrderOrderByIdDesc(order);
    }

    public List<OrderItem> listByProduct(Product product) {
        return orderItemDAO.findByProduct(product);
    }

    public int getSaleCount(Product product) {
        List<OrderItem> orderItems = listByProduct(product);
        int result = orderItems.stream().filter(orderItem -> null != orderItem.getOrder() && null != orderItem.getOrder().getPayDate())
                .mapToInt(OrderItem::getNumber)
                .sum();
        return result;
    }
}
