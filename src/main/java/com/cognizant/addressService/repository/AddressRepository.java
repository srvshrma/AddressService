package com.cognizant.addressService.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.addressService.model.Address;
@Repository
public interface AddressRepository extends CrudRepository<Address, Integer>{

	List<Address> findByPermanentAddress(String permanentAddress);
	List<Address> findByCurrentAddress(String currentAddress);
}
