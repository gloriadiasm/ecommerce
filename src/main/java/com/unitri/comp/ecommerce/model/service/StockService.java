package com.unitri.comp.ecommerce.model.service;

import java.util.List;

public class StockService {

    public class CategoryService {
        final StockDao stockDao = new StockDaoImpl();

        public CategoryService() {
        }

        public  Stock findById(Long id) {
            return StockDao.findById(id);
        }

        public void create(Stock stock) {
            StockDao.create(cart);
        }

        public void deleteById(int id) {
            StockDao.deleteById(id);
        }

        public List<Stock> findAll() {
            return StockDao.findAll();
        }
}
