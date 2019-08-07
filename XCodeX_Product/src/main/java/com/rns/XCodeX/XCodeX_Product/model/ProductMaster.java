package com.rns.XCodeX.XCodeX_Product.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "products_master")
@Entity
public class ProductMaster implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long idProdMaster;
	@Column(name = "application")
	private String productApplication;
	@Column(name = "created_by")
	private String productCreated_by;
	@Column(name = "created_at")
	private Long productCreated_at;
	@Column(name = "updated_by")
	private Long productUpdated_by;
	@Column(name = "updated_at")
	private Long productUpdated_at;
	@Column(name = "idprodmaster")
	private Long productIdProdmaster;
	@Column(name = "application_acronym")
	private String application_acronym;

	public Long getIdProdMaster() {
		return idProdMaster;
	}

	public void setIdProdMaster(Long idProdMaster) {
		this.idProdMaster = idProdMaster;
	}

	public String getProductApplication() {
		return productApplication;
	}

	public void setProductApplication(String productApplication) {
		this.productApplication = productApplication;
	}

	public String getProductCreated_by() {
		return productCreated_by;
	}

	public void setProductCreated_by(String productCreated_by) {
		this.productCreated_by = productCreated_by;
	}

	public Long getProductCreated_at() {
		return productCreated_at;
	}

	public void setProductCreated_at(Long productCreated_at) {
		this.productCreated_at = productCreated_at;
	}

	public Long getProductUpdated_by() {
		return productUpdated_by;
	}

	public void setProductUpdated_by(Long productUpdated_by) {
		this.productUpdated_by = productUpdated_by;
	}

	public Long getProductUpdated_at() {
		return productUpdated_at;
	}

	public void setProductUpdated_at(Long productUpdated_at) {
		this.productUpdated_at = productUpdated_at;
	}

	public Long getProductIdProdmaster() {
		return productIdProdmaster;
	}

	public void setProductIdProdmaster(Long productIdProdmaster) {
		this.productIdProdmaster = productIdProdmaster;
	}

	public String getApplication_acronym() {
		return application_acronym;
	}

	public void setApplication_acronym(String application_acronym) {
		this.application_acronym = application_acronym;
	}

}
