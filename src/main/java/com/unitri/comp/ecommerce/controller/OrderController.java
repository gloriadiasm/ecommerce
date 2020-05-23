package com.unitri.comp.ecommerce.controller;

import com.unitri.comp.ecommerce.model.entity.Order;
import com.unitri.comp.ecommerce.model.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    final OrderService orderService;

    OrderController() throws SQLException {
        this.orderService = new OrderService();
    }

    @GetMapping("/{id}")
    public Order findById(@PathVariable int id) {
        return orderService.findById(id);
    }
    @PostMapping("/create")
    void create(@RequestBody Order order) {
        orderService.create(order);
    }
    @DeleteMapping("/{id}")
    void deleteById(@PathVariable  int id) throws SQLException {
        orderService.deleteById(id);
    }
    @GetMapping
    List<Order> findAll() throws SQLException {
        return orderService.findAll();
    }

}
