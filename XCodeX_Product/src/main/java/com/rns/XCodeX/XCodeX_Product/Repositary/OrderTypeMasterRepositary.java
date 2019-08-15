package com.rns.XCodeX.XCodeX_Product.Repositary;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rns.XCodeX.XCodeX_Product.model.OrderTypeMaster;

@Repository
public interface OrderTypeMasterRepositary extends CrudRepository<OrderTypeMaster, Long> {
	List<OrderTypeMaster> findAllByOrderByTypeAsc();
}
