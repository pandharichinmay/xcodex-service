package com.rns.XCodeX.XCodeX_Product.Repositary;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rns.XCodeX.XCodeX_Product.model.OrderProductMapping;
@Repository
public interface OrderProductMappingRepositary extends CrudRepository<OrderProductMapping, Long>{

}
