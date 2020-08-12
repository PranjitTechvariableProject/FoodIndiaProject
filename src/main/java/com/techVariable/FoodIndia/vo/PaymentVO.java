package com.techVariable.FoodIndia.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="payment_type")
public class PaymentVO {
	@Id
	@Column(name="PAYMENT_TYPE_ID") 
	private int id;
	@Column(name="PAYMENT_TYPE")
	private String paymentType;

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "PaymentVO [id=" + id + ", paymentType=" + paymentType + "]";
	}

	
}
