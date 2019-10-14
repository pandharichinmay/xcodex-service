package com.rns.XCodeX.XCodeX_Product.Repositary;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rns.XCodeX.XCodeX_Product.model.OrderMaster;

@Repository
public interface OrderMasterRepositary extends CrudRepository<OrderMaster, Long> {
	List<OrderMaster> findAll();

	// @Query("FROM OrderMaster where active_flag='A'")
	List<OrderMaster> findTop10ByAssignedTo_idUser_OrderByUpdatedDateDesc(Long assignId);

	Optional<OrderMaster> findByidOrder(Long idOrder);

	@Query("FROM OrderMaster where status_id!=2 AND active_flag='A' AND (orderCreated_by.idUser =:assignId OR assignedTo.idUser=:assignId)")
	List<OrderMaster> findOrdersAssignedTo(@org.springframework.data.repository.query.Param("assignId") Long assignId);

	@Query("FROM OrderMaster where status_id!=2 AND active_flag='A'")
	List<OrderMaster> findAllOrders();

	@Query("FROM OrderMaster where status_id!=2 AND active_flag='A'")
	List<OrderMaster> findAllOrders(PageRequest of);

	@Query("FROM OrderMaster where status_id!=2 AND active_flag='A' AND (orderCreated_by.idUser =:assignId OR assignedTo.idUser=:assignId)")
	List<OrderMaster> findOrdersAssignedTo(@org.springframework.data.repository.query.Param("assignId") Long assignId,
			Pageable pageable);
	/*
	 * @Query("FROM OrderMaster where status_id!=2 AND active_flag='A' AND (orderCreated_by.idUser =:assignId OR assignedTo.idUser=:assignId)"
	 * ) List<OrderMaster> findOrdersAssignedTo(PageRequest of, Long assignId);
	 */
}
