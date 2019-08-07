package com.rns.XCodeX.XCodeX_Product.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "order_status_master")
@Entity
public class OrderStatusMaster implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long idOrderstatus;
	@Column(name = "status")
	private String status;
	@Column(name = "sequence_id")
	private Long sequence_id;
	@Column(name = "created_by")
	private Long orderstatuscreated_by;
	@Column(name = "created_at")
	private Date orderstatuscreated_at;
	@Column(name = "updated_by")
	private Date orderstatusupdated_by;
	@Column(name = "updated_at")
	private Date orderstatusupdated_at;

	public Long getIdOrderstatus() {
		return idOrderstatus;
	}

	public void setIdOrderstatus(Long idOrderstatus) {
		this.idOrderstatus = idOrderstatus;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getSequence_id() {
		return sequence_id;
	}

	public void setSequence_id(Long sequence_id) {
		this.sequence_id = sequence_id;
	}

	public Long getOrderstatuscreated_by() {
		return orderstatuscreated_by;
	}

	public void setOrderstatuscreated_by(Long orderstatuscreated_by) {
		this.orderstatuscreated_by = orderstatuscreated_by;
	}

	public Date getOrderstatuscreated_at() {
		return orderstatuscreated_at;
	}

	public void setOrderstatuscreated_at(Date orderstatuscreated_at) {
		this.orderstatuscreated_at = orderstatuscreated_at;
	}

	public Date getOrderstatusupdated_by() {
		return orderstatusupdated_by;
	}

	public void setOrderstatusupdated_by(Date orderstatusupdated_by) {
		this.orderstatusupdated_by = orderstatusupdated_by;
	}

	public Date getOrderstatusupdated_at() {
		return orderstatusupdated_at;
	}

	public void setOrderstatusupdated_at(Date orderstatusupdated_at) {
		this.orderstatusupdated_at = orderstatusupdated_at;
	}

}
