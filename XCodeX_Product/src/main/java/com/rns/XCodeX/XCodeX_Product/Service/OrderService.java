package com.rns.XCodeX.XCodeX_Product.Service;

import java.util.List;


import com.rns.XCodeX.XCodeX_Product.model.CategoryMaster;
import com.rns.XCodeX.XCodeX_Product.model.CustomerMaster;
import com.rns.XCodeX.XCodeX_Product.model.DepartmentMaster;
import com.rns.XCodeX.XCodeX_Product.model.OrderHistoryLog;
import com.rns.XCodeX.XCodeX_Product.model.OrderMaster;
import com.rns.XCodeX.XCodeX_Product.model.OrderStatusMaster;
import com.rns.XCodeX.XCodeX_Product.model.OrderTypeMaster;
import com.rns.XCodeX.XCodeX_Product.model.PriorityMaster;
import com.rns.XCodeX.XCodeX_Product.model.ProductMaster;

public interface OrderService {
	List<ProductMaster> getAllProducts();

	List<PriorityMaster> getAllPriority();

	List<OrderStatusMaster> getAllStatus();

	List<OrderTypeMaster> getOrderType();

	List<CustomerMaster> getAllCustomer();

	List<DepartmentMaster> getAllDepartment();

	List<CategoryMaster> getAllOrderCategory();

	List<OrderMaster> getAllOrders();

	List<OrderMaster> getOrdersbyAssignTo(Long assignId);

	List<OrderHistoryLog> getOrderHistory(Long orderId);

}
