package com.rns.XCodeX.XCodeX_Product.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "order_type_master")
@Entity
public class OrderTypeMaster implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long idOrdertype;
	@Column(name = "type")
	private String type;
	@Column(name = "description")
	private String orderTypeDescription;

	public Long getIdOrdertype() {
		return idOrdertype;
	}

	public void setIdOrdertype(Long idOrdertype) {
		this.idOrdertype = idOrdertype;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOrderTypeDescription() {
		return orderTypeDescription;
	}

	public void setOrderTypeDescription(String orderTypeDescription) {
		this.orderTypeDescription = orderTypeDescription;
	}

}
