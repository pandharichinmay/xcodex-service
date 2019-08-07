package com.rns.XCodeX.XCodeX_Product.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "order_replies")
@Entity
public class OrderReplies implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long idOrderrpl;
	@Column(name = "ticketid")
	private Long rplTicketid;
	@Column(name = "peopleid")
	private Long peopleid;
	@Column(name = "message")
	private String message;
	@Column(name = "timestamp")
	private String replyTimestamp;

	public Long getIdOrderrpl() {
		return idOrderrpl;
	}

	public void setIdOrderrpl(Long idOrderrpl) {
		this.idOrderrpl = idOrderrpl;
	}

	public Long getRplTicketid() {
		return rplTicketid;
	}

	public void setRplTicketid(Long rplTicketid) {
		this.rplTicketid = rplTicketid;
	}

	public Long getPeopleid() {
		return peopleid;
	}

	public void setPeopleid(Long peopleid) {
		this.peopleid = peopleid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getReplyTimestamp() {
		return replyTimestamp;
	}

	public void setReplyTimestamp(String replyTimestamp) {
		this.replyTimestamp = replyTimestamp;
	}
}
