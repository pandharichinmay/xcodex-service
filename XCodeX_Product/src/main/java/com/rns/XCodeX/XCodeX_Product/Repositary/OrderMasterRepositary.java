package com.rns.XCodeX.XCodeX_Product.Repositary;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.rns.XCodeX.XCodeX_Product.model.OrderMaster;

@Repository
public interface OrderMasterRepositary extends CrudRepository<OrderMaster, Long> {
	List<OrderMaster> findAll();
	List<OrderMaster> findTop10ByAssignedTo_idUser_OrderByUpdatedDateDesc(Long assignId);
	Optional<OrderMaster> findByidOrder(Long idOrder);
}
