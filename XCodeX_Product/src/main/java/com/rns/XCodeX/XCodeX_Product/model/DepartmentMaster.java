package com.rns.XCodeX.XCodeX_Product.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "department_master")
@Entity
public class DepartmentMaster implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long idDept;
	@Column(name = "business_unit")
	private String businessUnit;
	@Column(name = "active")
	private String active;
	@Column(name = "created_by")
	private Long deptCreated_by;
	@Column(name = "created_at")
	private Date deptCreated_at;
	@Column(name = "updated_by")
	private Date deptUpdated_by;
	@Column(name = "updated_at")
	private Date deptUpdated_at;

	
	public String getBusinessUnit() {
		return businessUnit;
	}

	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Long getIdDept() {
		return idDept;
	}

	public void setIdDept(Long idDept) {
		this.idDept = idDept;
	}

	public Long getDeptCreated_by() {
		return deptCreated_by;
	}

	public void setDeptCreated_by(Long deptCreated_by) {
		this.deptCreated_by = deptCreated_by;
	}

	public Date getDeptCreated_at() {
		return deptCreated_at;
	}

	public void setDeptCreated_at(Date deptCreated_at) {
		this.deptCreated_at = deptCreated_at;
	}

	public Date getDeptUpdated_by() {
		return deptUpdated_by;
	}

	public void setDeptUpdated_by(Date deptUpdated_by) {
		this.deptUpdated_by = deptUpdated_by;
	}

	public Date getDeptUpdated_at() {
		return deptUpdated_at;
	}

	public void setDeptUpdated_at(Date deptUpdated_at) {
		this.deptUpdated_at = deptUpdated_at;
	}

}
