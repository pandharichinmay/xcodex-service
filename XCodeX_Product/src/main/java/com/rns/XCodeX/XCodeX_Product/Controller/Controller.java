package com.rns.XCodeX.XCodeX_Product.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rns.XCodeX.XCodeX_Product.Service.OrderService;
import com.rns.XCodeX.XCodeX_Product.Service.UserService;
import com.rns.XCodeX.XCodeX_Product.domain.CodexNotificationRequest;
import com.rns.XCodeX.XCodeX_Product.model.CategoryMaster;
import com.rns.XCodeX.XCodeX_Product.model.CustomerMaster;
import com.rns.XCodeX.XCodeX_Product.model.DepartmentMaster;
import com.rns.XCodeX.XCodeX_Product.model.DeviceMaster;
import com.rns.XCodeX.XCodeX_Product.model.OrderHistoryLog;
import com.rns.XCodeX.XCodeX_Product.model.OrderMaster;
import com.rns.XCodeX.XCodeX_Product.model.OrderStatusMaster;
import com.rns.XCodeX.XCodeX_Product.model.OrderTypeMaster;
import com.rns.XCodeX.XCodeX_Product.model.PriorityMaster;
import com.rns.XCodeX.XCodeX_Product.model.ProductMaster;
import com.rns.XCodeX.XCodeX_Product.model.UserMaster;

@RestController
@CrossOrigin(origins = "*")

public class Controller {
	@Autowired
	private OrderService orderService;
	@Autowired
	private UserService userService;

	@RequestMapping("/getAllProducts")
	public List<ProductMaster> getAllProducts() {
		List<ProductMaster> allproducts = orderService.getAllProducts();
		System.out.println("Product List => " + allproducts);
		return allproducts;
	}

	@RequestMapping("/getAllPriority")
	public List<PriorityMaster> getAllPriority() {
		List<PriorityMaster> allpriority = orderService.getAllPriority();
		System.out.println("Priority List => " + allpriority);
		return allpriority;
	}

	@RequestMapping("/getAllStatus")
	public List<OrderStatusMaster> getAllStatus() {
		List<OrderStatusMaster> allstatus = orderService.getAllStatus();
		System.out.println("Status List => " + allstatus);
		return allstatus;
	}

	@RequestMapping("/getOrderType")
	public List<OrderTypeMaster> getOrderType() {
		List<OrderTypeMaster> alltypes = orderService.getOrderType();
		System.out.println("Order Types => " + alltypes);
		return alltypes;
	}

	@RequestMapping("/getAllCustomer")
	public List<CustomerMaster> getAllCustomer() {
		List<CustomerMaster> allcustomer = orderService.getAllCustomer();
		System.out.println("Customer List => " + allcustomer);
		return allcustomer;
	}

	@RequestMapping("/getAllDepartment")
	public List<DepartmentMaster> getAllDepartment() {
		List<DepartmentMaster> alldepartment = orderService.getAllDepartment();
		System.out.println("Department List => " + alldepartment);
		return alldepartment;
	}

	@RequestMapping("/getAllOrderCategory")
	public List<CategoryMaster> getAllOrderCategory() {
		List<CategoryMaster> allcategory = orderService.getAllOrderCategory();
		System.out.println("Order Categories => " + allcategory);
		return allcategory;
	}

	@RequestMapping("/getAllOrders")
	public List<OrderMaster> getAllOrders() {
		List<OrderMaster> allorder = orderService.getAllOrders();
		System.out.println("List of Orders => " + allorder);
		return allorder;
	}
//main
	@RequestMapping("/getOrdersbyAssignTo/{assignId}")
	public List<OrderMaster> getOrdersAssignedTo(@PathVariable Long assignId) {
		return orderService.getOrdersbyAssignTo(assignId);
	}

	@RequestMapping("/getOrderHistory/{orderId}")
	public List<OrderHistoryLog> getOrderHistory(@PathVariable Long orderId) {
		return orderService.getOrderHistory(orderId);
	}

	@RequestMapping("/getAllUsersByEmail/{email}")
	public List<UserMaster> getAllUsersByEmail(@PathVariable String email) {
		return userService.getAllUsersByEmail(email);
	}

	@PostMapping("/loginUser")
	public ResponseEntity<Object> loginUser(@RequestBody UserMaster userMaster) {
		UserMaster login = userService.login(userMaster);
		if (login == null) {
			// User not found as email or password is incorrect
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(login);
	}

	@RequestMapping("/getAllUsers")
	public List<UserMaster> getAllUsers() {
		List<UserMaster> alluser = userService.getAllUsers();
		System.out.println("List of Users => " + alluser);
		return alluser;
	}

	@RequestMapping("/getOrderDetails/{idOrder}")
	public Optional<OrderMaster> getOrderDetails(@PathVariable Long idOrder) {
		return orderService.getOrderDetails(idOrder);
	}

	@RequestMapping("/getOrderDetailsByUserId/{assignId}")
	public List<OrderMaster> getOrderDetailsByUserId(@PathVariable Long assignId) {
		return orderService.getOrderDetailsByUserId(assignId);
	}

	@PostMapping("/addDevice")
	public void addDevice(@RequestBody DeviceMaster deviceMaster) {
		orderService.addDevice(deviceMaster);
	}

	@PostMapping("/notifyUsers")
	public void notifyUsers(@RequestBody CodexNotificationRequest request) {
		orderService.notifyUsers(request);
	}

	@RequestMapping("/getAllOrdersBySearch")
	public List<OrderMaster> getAllOrdersSearch() {
		List<OrderMaster> allorder = orderService.getAllOrdersSearch();
		System.out.println("List of Orders by search => " + allorder);
		return allorder;
	}

	@RequestMapping("/getLimitedOrders/{limit}")
	public List<OrderMaster> getLimitedOrders(@PathVariable int limit) {
		List<OrderMaster> allorders = orderService.getLimitedOrders(limit);
		System.out.println("List of Orders by search => " + allorders);
		return allorders;
	}

	@RequestMapping("/getLimitedOrdersbyAssignTo/{assignId}/{limit}")
	public List<OrderMaster> getLimitedOrdersbyAssignTo(@PathVariable Long assignId, @PathVariable int limit) {
		return orderService.getLimitedOrdersbyAssignTo(assignId, limit);
	}

	@RequestMapping("/loadProfile/{idUser}")
	public UserMaster loadProfile(@PathVariable Long idUser) {
		UserMaster request = new UserMaster();
		request.setIdUser(idUser);
		return userService.loadProfile(request);

	}
}
