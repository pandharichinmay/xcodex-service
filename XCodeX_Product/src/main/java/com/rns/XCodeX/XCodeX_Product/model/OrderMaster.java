package com.rns.XCodeX.XCodeX_Product.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "order_master")
@Entity
public class OrderMaster implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long idOrder;
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "created_by", referencedColumnName = "id", insertable = false, updatable = false)
	private UserMaster orderCreated_by;
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "priority_id", referencedColumnName = "id", insertable = false, updatable = false)
	private PriorityMaster priority_id;
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", referencedColumnName = "id", insertable = false, updatable = false)
	private CategoryMaster category_id;
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "status_id", referencedColumnName = "id", insertable = false, updatable = false)
	private OrderStatusMaster status_id;
	@Column(name = "start_date")
	private Date start_date;
	@Column(name = "created_at")
	private Date orderCreated_at;
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "updated_by", referencedColumnName = "id", insertable = false, updatable = false)
	private UserMaster orderUpdated_by;
	@Column(name = "updated_at")
	private Date updatedDate;
	@Column(name = "due_date")
	private Date due_date;
	@Column(name = "end_date")
	private Date end_date;
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "assigned_to", referencedColumnName = "id", insertable = false, updatable = false)
	private UserMaster assignedTo;
	@Column(name = "title")
	private String title;
	@Column(name = "requester_id")
	private Long requester_id;
	@Column(name = "tracking_number")
	private String tracking_number;
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "departmentid", referencedColumnName = "id", insertable = false, updatable = false)
	private DepartmentMaster departmentid;
	@Column(name = "adminid")
	private Long adminid;
	@Column(name = "ccs")
	private String ccs;
	@Column(name = "closure_code")
	private String closure_code;
	@Column(name = "ticket_type")
	private String ticket_type;
	@Column(name = "impacted_applications")
	private String impacted_applications;
	@Column(name = "ticket_closed_date")
	private String ticket_closed_date;
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "ticket_closed_by", referencedColumnName = "id", insertable = false, updatable = false)
	private UserMaster ticket_closed_by;
	@Column(name = "active_flag")
	private String active_flag;
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", referencedColumnName = "id", insertable = false, updatable = false)
	private CustomerMaster customer_id;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, mappedBy = "order_id")
	private List<OrderProductMapping> products;
	
	public Long getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Long idOrder) {
		this.idOrder = idOrder;
	}

	public UserMaster getOrderCreated_by() {
		return orderCreated_by;
	}

	public void setOrderCreated_by(UserMaster orderCreated_by) {
		this.orderCreated_by = orderCreated_by;
	}

	public PriorityMaster getPriority_id() {
		return priority_id;
	}

	public void setPriority_id(PriorityMaster priority_id) {
		this.priority_id = priority_id;
	}

	public CategoryMaster getCategory_id() {
		return category_id;
	}

	public void setCategory_id(CategoryMaster category_id) {
		this.category_id = category_id;
	}

	public OrderStatusMaster getStatus_id() {
		return status_id;
	}

	public void setStatus_id(OrderStatusMaster status_id) {
		this.status_id = status_id;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getOrderCreated_at() {
		return orderCreated_at;
	}

	public void setOrderCreated_at(Date orderCreated_at) {
		this.orderCreated_at = orderCreated_at;
	}

	public UserMaster getOrderUpdated_by() {
		return orderUpdated_by;
	}

	public void setOrderUpdated_by(UserMaster orderUpdated_by) {
		this.orderUpdated_by = orderUpdated_by;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date date) {
		this.updatedDate = date;
	}

	public Date getDue_date() {
		return due_date;
	}

	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public UserMaster getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(UserMaster assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getRequester_id() {
		return requester_id;
	}

	public void setRequester_id(Long requester_id) {
		this.requester_id = requester_id;
	}

	public String getTracking_number() {
		return tracking_number;
	}

	public void setTracking_number(String tracking_number) {
		this.tracking_number = tracking_number;
	}

	public DepartmentMaster getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(DepartmentMaster departmentid) {
		this.departmentid = departmentid;
	}

	public Long getAdminid() {
		return adminid;
	}

	public void setAdminid(Long adminid) {
		this.adminid = adminid;
	}

	public String getCcs() {
		return ccs;
	}

	public void setCcs(String ccs) {
		this.ccs = ccs;
	}

	public String getClosure_code() {
		return closure_code;
	}

	public void setClosure_code(String closure_code) {
		this.closure_code = closure_code;
	}

	public String getTicket_type() {
		return ticket_type;
	}

	public void setTicket_type(String ticket_type) {
		this.ticket_type = ticket_type;
	}

	public String getImpacted_applications() {
		return impacted_applications;
	}

	public void setImpacted_applications(String impacted_applications) {
		this.impacted_applications = impacted_applications;
	}

	public String getTicket_closed_date() {
		return ticket_closed_date;
	}

	public void setTicket_closed_date(String ticket_closed_date) {
		this.ticket_closed_date = ticket_closed_date;
	}

	public UserMaster getTicket_closed_by() {
		return ticket_closed_by;
	}

	public void setTicket_closed_by(UserMaster ticket_closed_by) {
		this.ticket_closed_by = ticket_closed_by;
	}

	public String getActive_flag() {
		return active_flag;
	}

	public void setActive_flag(String active_flag) {
		this.active_flag = active_flag;
	}

	public CustomerMaster getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(CustomerMaster customer_id) {
		this.customer_id = customer_id;
	}
	
	public List<OrderProductMapping> getProducts() {
		return products;
	}
	
	public void setProducts(List<OrderProductMapping> products) {
		this.products = products;
	}

}
