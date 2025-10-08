package com.web.aulaproject.entities;

public enum EnumOrder {

	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;
	
	private EnumOrder(int code) {
		this.code = code;
	}
	
	
}
