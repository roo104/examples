package com.blogspot.jpdevelopment.immutable.hibernate.access;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Order {

	@Id
	@Column(columnDefinition = "BINARY(16)", length = 16)
	private UUID orderId;
	private Date creationDate;

	private Order() {
		this.orderId = UUID.randomUUID();
		this.creationDate = new Date();
	}

	public UUID getOrderId() {
		return this.orderId;
	}

	public static Order createOrder() {
		return new Order();
	}

}
