package com.cognizant.addressService.exception;

@SuppressWarnings("serial")
public class AddressNotFoundException extends Exception{
	
	public AddressNotFoundException(String message) {
		super(message);
	}

}
