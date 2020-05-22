package com.unitri.comp.ecommerce.controller;

import com.unitri.comp.ecommerce.model.entity.CartItems;
import com.unitri.comp.ecommerce.model.service.CartItemsService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/cart/items")
public class CartItemsController {

    final CartItemsService cartItemsService;

    CartItemsController() throws SQLException {
        this.cartItemsService = new CartItemsService();
    }

    @GetMapping("/{id}")
    public CartItems findById(@PathVariable int id) throws SQLException {

        return cartItemsService.findById(id);
    }
    @PostMapping("/create")
    void create(@RequestBody CartItems cartItems) throws SQLException {

        cartItemsService.create(cartItems);
    }
    @DeleteMapping("/{id}")
    void deleteById(@PathVariable  int id) throws SQLException {

        cartItemsService.deleteById(id);
    }
    @GetMapping
    List<CartItems> findAll() throws SQLException {

        return cartItemsService.findAll();
    }
}
