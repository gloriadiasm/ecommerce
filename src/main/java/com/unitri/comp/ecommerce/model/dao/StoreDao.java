package com.unitri.comp.ecommerce.model.dao;

import com.unitri.comp.ecommerce.model.entity.Store;

public interface StoreDao extends GenericDao<Store, Integer>{
    Store update(Store store);
}
