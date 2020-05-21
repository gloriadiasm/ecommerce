package com.unitri.comp.ecommerce.model.service;

import com.unitri.comp.ecommerce.model.dao.StockDao;
import com.unitri.comp.ecommerce.model.dao.impl.StockDaoImpl;
import com.unitri.comp.ecommerce.model.entity.Stock;

import java.util.List;

public class StockService {

        final StockDao stockDao = new StockDaoImpl();

        public StockService() {
        }

    public List<Stock> findAll() {
            return StockDao.findAll();
        }
}
