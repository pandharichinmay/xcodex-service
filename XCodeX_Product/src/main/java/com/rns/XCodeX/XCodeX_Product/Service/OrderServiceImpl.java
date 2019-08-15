package com.rns.XCodeX.XCodeX_Product.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rns.XCodeX.XCodeX_Product.Repositary.CategoryMasterRepositary;
import com.rns.XCodeX.XCodeX_Product.Repositary.CustomerMasterRepositary;
import com.rns.XCodeX.XCodeX_Product.Repositary.DepartmentMasterRepositary;
import com.rns.XCodeX.XCodeX_Product.Repositary.OrderHistoryLogRepositary;
import com.rns.XCodeX.XCodeX_Product.Repositary.OrderMasterRepositary;
import com.rns.XCodeX.XCodeX_Product.Repositary.OrderStatusMasterRepositary;
import com.rns.XCodeX.XCodeX_Product.Repositary.OrderTypeMasterRepositary;
import com.rns.XCodeX.XCodeX_Product.Repositary.PriorityMasterRepositary;
import com.rns.XCodeX.XCodeX_Product.Repositary.ProductMasterRepositary;
import com.rns.XCodeX.XCodeX_Product.model.CategoryMaster;
import com.rns.XCodeX.XCodeX_Product.model.CustomerMaster;
import com.rns.XCodeX.XCodeX_Product.model.DepartmentMaster;
import com.rns.XCodeX.XCodeX_Product.model.OrderHistoryLog;
import com.rns.XCodeX.XCodeX_Product.model.OrderMaster;
import com.rns.XCodeX.XCodeX_Product.model.OrderStatusMaster;
import com.rns.XCodeX.XCodeX_Product.model.OrderTypeMaster;
import com.rns.XCodeX.XCodeX_Product.model.PriorityMaster;
import com.rns.XCodeX.XCodeX_Product.model.ProductMaster;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private ProductMasterRepositary productMasterRepositary;
	@Autowired
	private PriorityMasterRepositary priorityMasterRepositary;
	@Autowired
	private OrderStatusMasterRepositary orderStatusMasterRepositary;
	@Autowired
	private OrderTypeMasterRepositary orderTypeMasterRepositary;
	@Autowired
	private CustomerMasterRepositary customerMasterRepositary;
	@Autowired
	private DepartmentMasterRepositary departmentMasterRepositary;
	@Autowired
	private CategoryMasterRepositary categoryMasterRepositary;
	@Autowired
	private OrderMasterRepositary orderMasterRepositary;
	@Autowired
	private OrderHistoryLogRepositary orderHistoryLogRepositary;

	public List<ProductMaster> getAllProducts() {
		System.out.println("All Products!..");
		return productMasterRepositary.findAllByOrderByProductApplicationAsc();
	}

	public List<PriorityMaster> getAllPriority() {
		System.out.println("All Priorities!..");
		return priorityMasterRepositary.findAll();
	}

	public List<OrderStatusMaster> getAllStatus() {
		System.out.println("Order Status!..");
		return orderStatusMasterRepositary.findAll();
	}

	public List<OrderTypeMaster> getOrderType() {
		System.out.println("Order Types!..");
		return orderTypeMasterRepositary.findAllByOrderByTypeAsc();

	}

	public List<CustomerMaster> getAllCustomer() {
		System.out.println("All Customers!..");
		return customerMasterRepositary.findAllByOrderByCustNameAsc();
	}

	public List<DepartmentMaster> getAllDepartment() {
		System.out.println("All Departments!..");
		return departmentMasterRepositary.findAllByOrderByBusinessUnitAsc();
	}

	public List<CategoryMaster> getAllOrderCategory() {
		System.out.println("All Order Categories!..");
		return categoryMasterRepositary.findAllByOrderByCategoryAsc();
	}

	public List<OrderMaster> getAllOrders() {
		System.out.println("All Orders List!..");
		return orderMasterRepositary.findAll();
	}

	public List<OrderMaster> getOrdersbyAssignTo(Long assignId) {
		System.out.println("Orders by Assign To!.." + assignId);
		return orderMasterRepositary.findTop10ByAssignedTo_idUser_OrderByUpdatedDateDesc(assignId);

	}

	public List<OrderHistoryLog> getOrderHistory(Long orderId) {
		System.out.println("History Log By Order!.." + orderId);
		return orderHistoryLogRepositary.findAllByTicketId_idOrder_OrderByTimestampDesc(orderId);

	}

	@Override
	public Optional<OrderMaster> getOrderDetails(Long idOrder) {
		System.out.println("Order Details By Order Id!.." + idOrder);
		return orderMasterRepositary.findByidOrder(idOrder);
	}

}
