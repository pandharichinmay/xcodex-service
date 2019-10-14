package com.rns.XCodeX.XCodeX_Product.Service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.rns.XCodeX.XCodeX_Product.Repositary.CategoryMasterRepositary;
import com.rns.XCodeX.XCodeX_Product.Repositary.CustomerMasterRepositary;
import com.rns.XCodeX.XCodeX_Product.Repositary.DepartmentMasterRepositary;
import com.rns.XCodeX.XCodeX_Product.Repositary.DeviceMasterRepository;
import com.rns.XCodeX.XCodeX_Product.Repositary.OrderHistoryLogRepositary;
import com.rns.XCodeX.XCodeX_Product.Repositary.OrderMasterRepositary;
import com.rns.XCodeX.XCodeX_Product.Repositary.OrderStatusMasterRepositary;
import com.rns.XCodeX.XCodeX_Product.Repositary.OrderTypeMasterRepositary;
import com.rns.XCodeX.XCodeX_Product.Repositary.PriorityMasterRepositary;
import com.rns.XCodeX.XCodeX_Product.Repositary.ProductMasterRepositary;
import com.rns.XCodeX.XCodeX_Product.domain.CodexNotification;
import com.rns.XCodeX.XCodeX_Product.domain.CodexNotificationObject;
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
import com.rns.XCodeX.XCodeX_Product.util.CodexFCMUtil;

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

	@Autowired
	private DeviceMasterRepository deviceMasterRepository;

	public List<ProductMaster> getAllProducts() {
		System.out.println("All Products!..");
		return productMasterRepositary.findAllByOrderByProductApplicationAsc();
	}

	public List<PriorityMaster> getAllPriority() {
		System.out.println("All Priorities!..");
		return priorityMasterRepositary.findAll();
	}

	public List<OrderStatusMaster> getAllStatus() {
		System.out.println("Order Status order by sequence ID!..");
		return orderStatusMasterRepositary.findAllByOrderBySequenceIdAsc();
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
//main
	public List<OrderMaster> getOrdersbyAssignTo(Long assignId) {
		System.out.println("Orders by Assign To!.." + assignId);
		List<OrderMaster> assignedOrders = orderMasterRepositary.findOrdersAssignedTo(assignId);
		for (OrderMaster orderMaster : assignedOrders) {
			orderMaster.setTimeleft(timeLeftMethod(orderMaster.getDue_date(), new Date()));
		}
		return assignedOrders;
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

	@Override
	public List<OrderMaster> getOrderDetailsByUserId(Long assignId) {
		System.out.println("Order Details By Order Id!.." + assignId);
		List<OrderMaster> assignedOrders = orderMasterRepositary.findOrdersAssignedTo(assignId);

		for (OrderMaster orderMaster : assignedOrders) {
			orderMaster.setTimeleft(timeLeftMethod(orderMaster.getDue_date(), new Date()));
		}
		return assignedOrders;

	}

	// @Override
	public void addDevice(DeviceMaster deviceMaster) {
		System.out.println("Add Device :- ");
		Optional<DeviceMaster> existing = deviceMasterRepository.findByDeviceId(deviceMaster.getDeviceId());
		if (!existing.isPresent()) {
			// Add device ID only if same device ID is not already present
			System.out.println("User Id :- " + deviceMaster.getIdUser());
			deviceMaster.setIdUser(deviceMaster.getIdUser());
			deviceMaster.setCreatedDate(new Date());
			deviceMaster.setDeviceId(deviceMaster.getDeviceId());
			deviceMasterRepository.save(deviceMaster);
		}
	}

	// @Override
	public void notifyUsers(CodexNotificationRequest request) {
		try {

			if (request == null || CollectionUtils.isEmpty(request.getUsers()) || request.getTitle() == null
					|| request.getBody() == null) {
				return;
			}
			// Fetch device IDs
			List<DeviceMaster> devices = deviceMasterRepository.findByIdUser_idUserIn(request.getUsers());
			if (!CollectionUtils.isEmpty(devices)) {
				List<String> deviceIds = new ArrayList<>();
				for (DeviceMaster device : devices) {
					deviceIds.add(device.getDeviceId());
				}
				CodexNotification notification = new CodexNotification();
				notification.setRegistration_ids(deviceIds);
				CodexNotificationObject notify = new CodexNotificationObject();
				notify.setBody(request.getBody());
				notify.setTitle(request.getTitle());
				notify.setAndroid_channel_id("Codex");
				notification.setNotification(notify);

				CodexFCMUtil.postNotification(notification);
			}
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<OrderMaster> getAllOrdersSearch() {
		System.out.println("All Orders List for Search!..");
		return orderMasterRepositary.findAllOrders();
	}

	@Override
	public List<OrderMaster> getLimitedOrders(int limit) {
		return orderMasterRepositary.findAllOrders(PageRequest.of(0, limit, Sort.by(Sort.Direction.ASC, "idOrder")));

	}

	@Override
	public List<OrderMaster> getLimitedOrdersbyAssignTo(Long assignId, int limit) {
		System.out.println("Limited Orders by Assign To!.." + assignId);
		// for(OrderMaster obj:List<OrderMaster>)
		return orderMasterRepositary.findOrdersAssignedTo(assignId, PageRequest.of(0, limit));

	}

	public static String timeLeftMethod(Date d1, Date d2) {
		String difference = "";
		try {

			long diff = d2.getTime() - d1.getTime();

			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			long diffDays = diff / (24 * 60 * 60 * 1000);
			if (diffDays > 0) {
				difference = difference + diffDays + " days, ";

			}
			if (diffHours > 0) {
				difference = difference + diffHours + " hours, ";

			}
			if (diffMinutes > 0) {
				difference = difference + diffMinutes + " minutes, ";

			}
			if (diffSeconds > 0) {
				difference = difference + diffSeconds + " seconds ";

			}
			System.out.print(diffDays + " days, ");
			System.out.print(diffHours + " hours, ");
			System.out.print(diffMinutes + " minutes, ");
			System.out.print(diffSeconds + " seconds.");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return difference;
	}

	public static void main(String[] args) throws ParseException {
		String dateStart = "10/11/2019 09:29:58";
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date d1 = null;
		d1 = format.parse(dateStart);
		timeLeftMethod(d1, new Date());

	}
}
