package com.rns.XCodeX.XCodeX_Product.Repositary;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rns.XCodeX.XCodeX_Product.model.OrderHistoryLog;
@Repository
public interface OrderHistoryLogRepositary extends CrudRepository<OrderHistoryLog, Long>{
	
	List<OrderHistoryLog> findAllByTicketId_idOrder_OrderByTimestampDesc(Long orderId);
	
}
