package com.unitri.comp.ecommerce.controller;

import com.unitri.comp.ecommerce.model.entity.Address;
import com.unitri.comp.ecommerce.model.service.AddressService;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    final AddressService addressService;

    AddressController() {
        this.addressService = new AddressService();
    }

    @GetMapping("/{id}")
    public Address findById(@PathVariable int id) {

        return addressService.findById(id);
    }

    @PostMapping("/create")
    void create(@RequestBody Address address) {

        addressService.create(address);
    }
    @DeleteMapping("/{id}")
    void deleteById(@PathVariable  int id) {

        addressService.deleteById(id);
    }
    @GetMapping
    List<Address> findAll() {

        return addressService.findAll();
    }
}
