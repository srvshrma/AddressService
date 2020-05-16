package com.cognizant.addressService.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.addressService.model.Address;
@Repository
public interface AddressRepository extends CrudRepository<Address, Integer>{

	List<Address> findByStreetName(String name);
	List<Address> findByCity(String name);
	List<Address> findByCountry(String name);
}
