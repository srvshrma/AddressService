package com.cognizant.addressService.exception;

public enum ExceptionMessage {
	
	EMPTY("Address Not Found with id: "), 
	DUPLICATE("err"), 
	DATABASE("Try after some time"), 
	NOTEMPTY("* feild cannot be empty "), 
	Address_Street_Not_Found("Address Not Found of street name: "), 
	Address_City_Not_Found("Address Not Found with city: "),
	Address_Country_Not_Found("Address Not Found with country: "),
	NO_RECORD("No record found by id: ");
	private final String message;
	ExceptionMessage(String message)
	{
		this.message = message;
	}
	public String getMessage()
	{
		return this.message;
	}

}
