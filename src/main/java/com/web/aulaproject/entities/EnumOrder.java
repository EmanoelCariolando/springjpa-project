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

	public int getCode() {
		return code;
	}
	
    public static EnumOrder valueOf(int code){
    	for(EnumOrder value : EnumOrder.values()) {
    		if(code == value.getCode()){
    			return value;
    		}
    	
    	}
    	
    	throw new IllegalArgumentException();
    }
	
	
}
