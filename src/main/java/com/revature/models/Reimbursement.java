package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reimbursement", schema="ers")
public class Reimbursement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="reimb_id", unique = true, nullable = false)
	private int reimb_id;
	
	@Column(name="reimb_amount", nullable = false)
	private double reimb_amount;
	
	@Column(name="time_submitted", nullable = false)
	private String time_submitted;
	
	@Column(name="time_resolved")
	private String time_resolved;
	
	@Column(name="description", nullable = false)
	private String description;
	
	@Column(name="author", nullable = false)
	private int author;
	
	@Column(name="resolver", nullable = false)
	private int resolver;
	
	@Column(name="status_id", nullable = false)
	private int status_id;
	
	@Column(name="type_id", nullable = false)
	private int type_id;
	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reimbursement(int reimb_id, double reimb_amount, String time_submitted, String time_resolved,
			String description, int author, int resolver, int status_id, int type_id) {
		super();
		this.reimb_id = reimb_id;
		this.reimb_amount = reimb_amount;
		this.time_submitted = time_submitted;
		this.time_resolved = time_resolved;
		this.description = description;
		this.author = author;
		this.resolver = resolver;
		this.status_id = status_id;
		this.type_id = type_id;
	}

	public Reimbursement(double reimb_amount, String time_submitted, String time_resolved, String description,
			int author, int resolver, int status_id, int type_id) {
		super();
		this.reimb_amount = reimb_amount;
		this.time_submitted = time_submitted;
		this.time_resolved = time_resolved;
		this.description = description;
		this.author = author;
		this.resolver = resolver;
		this.status_id = status_id;
		this.type_id = type_id;
	}
	
	public int getReimb_id() {
		return reimb_id;
	}

	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}

	public double getReimb_amount() {
		return reimb_amount;
	}

	public void setReimb_amount(double reimb_amount) {
		this.reimb_amount = reimb_amount;
	}

	public String getTime_submitted() {
		return time_submitted;
	}

	public void setTime_submitted(String time_submitted) {
		this.time_submitted = time_submitted;
	}

	public String getTime_resolved() {
		return time_resolved;
	}

	public void setTime_resolved(String time_resolved) {
		this.time_resolved = time_resolved;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public int getResolver() {
		return resolver;
	}

	public void setResolver(int resolver) {
		this.resolver = resolver;
	}

	public int getStatus_id() {
		return status_id;
	}

	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}

	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + author;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		long temp;
		temp = Double.doubleToLongBits(reimb_amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + resolver;
		result = prime * result + status_id;
		result = prime * result + ((time_resolved == null) ? 0 : time_resolved.hashCode());
		result = prime * result + ((time_submitted == null) ? 0 : time_submitted.hashCode());
		result = prime * result + type_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		if (author != other.author)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (Double.doubleToLongBits(reimb_amount) != Double.doubleToLongBits(other.reimb_amount))
			return false;
		if (resolver != other.resolver)
			return false;
		if (status_id != other.status_id)
			return false;
		if (time_resolved == null) {
			if (other.time_resolved != null)
				return false;
		} else if (!time_resolved.equals(other.time_resolved))
			return false;
		if (time_submitted == null) {
			if (other.time_submitted != null)
				return false;
		} else if (!time_submitted.equals(other.time_submitted))
			return false;
		if (type_id != other.type_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimb_id=" + reimb_id + ", reimb_amount=" + reimb_amount + ", time_submitted="
				+ time_submitted + ", time_resolved=" + time_resolved + ", description=" + description + ", author="
				+ author + ", resolver=" + resolver + ", status_id=" + status_id + ", type_id=" + type_id + "]";
	}
}
