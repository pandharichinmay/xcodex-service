package com.rns.XCodeX.XCodeX_Product.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "order_history_log")
@Entity
public class OrderHistoryLog implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long idHistory;
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "ticket_id", referencedColumnName = "id", insertable = false, updatable = false)
	private OrderMaster ticketId;
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "people_id", referencedColumnName = "id", insertable = false, updatable = false)
	private UserMaster peopleId;
	@Column(name = "description")
	private String histoydescription;
	@Column(name = "comments")
	private String comments;
	@Column(name = "timestamp")
	private Date timestamp;
	
	//New columns
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "old_user", referencedColumnName = "id", insertable = false, updatable = false)
	private UserMaster oldUser;
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "new_user", referencedColumnName = "id", insertable = false, updatable = false)
	private UserMaster newUser;
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "old_status", referencedColumnName = "id", insertable = false, updatable = false)
	private OrderStatusMaster oldStatus;
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "new_status", referencedColumnName = "id", insertable = false, updatable = false)
	private OrderStatusMaster newStatus;
	private Integer timeLapsed;

	public Long getIdHistory() {
		return idHistory;
	}

	public void setIdHistory(Long idHistory) {
		this.idHistory = idHistory;
	}

	public OrderMaster getTicketId() {
		return ticketId;
	}

	public void setTicketId(OrderMaster ticketId) {
		this.ticketId = ticketId;
	}

	public UserMaster getPeopleId() {
		return peopleId;
	}

	public void setPeopleId(UserMaster peopleId) {
		this.peopleId = peopleId;
	}

	public String getHistoydescription() {
		return histoydescription;
	}

	public void setHistoydescription(String histoydescription) {
		this.histoydescription = histoydescription;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public UserMaster getOldUser() {
		return oldUser;
	}

	public void setOldUser(UserMaster oldUser) {
		this.oldUser = oldUser;
	}

	public UserMaster getNewUser() {
		return newUser;
	}

	public void setNewUser(UserMaster newUser) {
		this.newUser = newUser;
	}

	public OrderStatusMaster getOldStatus() {
		return oldStatus;
	}

	public void setOldStatus(OrderStatusMaster oldStatus) {
		this.oldStatus = oldStatus;
	}

	public OrderStatusMaster getNewStatus() {
		return newStatus;
	}

	public void setNewStatus(OrderStatusMaster newStatus) {
		this.newStatus = newStatus;
	}

	public Integer getTimeLapsed() {
		return timeLapsed;
	}

	public void setTimeLapsed(Integer timeLapsed) {
		this.timeLapsed = timeLapsed;
	}

}
