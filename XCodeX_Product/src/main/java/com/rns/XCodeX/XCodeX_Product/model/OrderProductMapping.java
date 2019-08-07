package com.rns.XCodeX.XCodeX_Product.model;

import java.io.Serializable;

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

@Table(name = "order_product_mapping")
@Entity
public class OrderProductMapping implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long idOrderproduct;
	@Column(name = "order_id")
	private Long order_id;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
	private ProductMaster product_id;

	@Column(name = "quantity")
	private Integer quantity;

	public Long getIdOrderproduct() {
		return idOrderproduct;
	}

	public void setIdOrderproduct(Long idOrderproduct) {
		this.idOrderproduct = idOrderproduct;
	}

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public ProductMaster getProduct_id() {
		return product_id;
	}

	public void setProduct_id(ProductMaster product_id) {
		this.product_id = product_id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
