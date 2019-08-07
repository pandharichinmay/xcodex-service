package com.rns.XCodeX.XCodeX_Product.Repositary;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rns.XCodeX.XCodeX_Product.model.OrderStatusMaster;


@Repository
public interface OrderStatusMasterRepositary extends CrudRepository<OrderStatusMaster, Long> {
	List<OrderStatusMaster> findAll();
}
