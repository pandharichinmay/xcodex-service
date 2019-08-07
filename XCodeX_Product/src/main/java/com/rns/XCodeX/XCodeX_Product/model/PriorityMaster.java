package com.rns.XCodeX.XCodeX_Product.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "priority_master")
@Entity
public class PriorityMaster implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long idPriority;
	@Column(name = "priority")
	private String priority;
	@Column(name = "created_by")
	private String priorityCreated_by;
	@Column(name = "created_at")
	private String priorityCreated_at;
	@Column(name = "updated_by")
	private String priorityUpdated_by;
	@Column(name = "updated_at")
	private String priorityUpdated_at;

	public Long getIdPriority() {
		return idPriority;
	}

	public void setIdPriority(Long idPriority) {
		this.idPriority = idPriority;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getPriorityCreated_by() {
		return priorityCreated_by;
	}

	public void setPriorityCreated_by(String priorityCreated_by) {
		this.priorityCreated_by = priorityCreated_by;
	}

	public String getPriorityCreated_at() {
		return priorityCreated_at;
	}

	public void setPriorityCreated_at(String priorityCreated_at) {
		this.priorityCreated_at = priorityCreated_at;
	}

	public String getPriorityUpdated_by() {
		return priorityUpdated_by;
	}

	public void setPriorityUpdated_by(String priorityUpdated_by) {
		this.priorityUpdated_by = priorityUpdated_by;
	}

	public String getPriorityUpdated_at() {
		return priorityUpdated_at;
	}

	public void setPriorityUpdated_at(String priorityUpdated_at) {
		this.priorityUpdated_at = priorityUpdated_at;
	}
}
