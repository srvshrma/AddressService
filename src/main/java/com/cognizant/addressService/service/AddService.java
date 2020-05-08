package com.cognizant.addressService.service;

import java.util.List;
import java.util.Optional;

import com.cognizant.addressService.model.Address;

public interface AddService {
	
	Address createAddress(Address address);
	Optional<Address> getAddressById(int id);
	public Iterable<Address> getAllAddress();
	List<Address> getByPermAdd(String permanentAddress);
	List<Address> getByCurrAdd(String currentAddress);
	public void updateById(Address address);
	public void deleteById(int id);
	

}
