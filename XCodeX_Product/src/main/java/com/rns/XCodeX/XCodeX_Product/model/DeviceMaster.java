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
import javax.websocket.Decoder.Text;

@Table(name = "device_ids")
@Entity
public class DeviceMaster implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iddevice", unique = true, nullable = false)
	private Long iddevice;
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private UserMaster idUser;
	@Column(name = "created_date")
	private Date createdDate;
	@Column(name = "device_id")
	private String deviceId;

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public Long getIddevice() {
		return iddevice;
	}

	public void setIddevice(Long iddevice) {
		this.iddevice = iddevice;
	}

	public UserMaster getIdUser() {
		return idUser;
	}

	public void setIdUser(UserMaster idUser) {
		this.idUser = idUser;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
