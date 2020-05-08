package com.cognizant.addressService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.addressService.model.Address;
import com.cognizant.addressService.repository.AddressRepository;
@Service
public class AddServiceImpl implements AddService {
	@Autowired
	AddressRepository aRepo; 

	@Override
	public Optional<Address> getAddressById(int id) {
		
		return aRepo.findById(id);
	}

	@Override
	public Address createAddress(Address address) {
		// TODO Auto-generated method stub
		return aRepo.save(address);
	}

	@Override
	public Iterable<Address> getAllAddress() {
		// TODO Auto-generated method stub
		return aRepo.findAll();
	}

	@Override
	public List<Address> getByPermAdd(String permanentAddress) {
		// TODO Auto-generated method stub
		return aRepo.findByPermanentAddress(permanentAddress);
	}

	@Override
	public List<Address> getByCurrAdd(String currentAddress) {
		// TODO Auto-generated method stub
		return aRepo.findByCurrentAddress(currentAddress);
	}

	@Override
	public void updateById(Address address) {
		// TODO Auto-generated method stub
		aRepo.save(address);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		aRepo.deleteById(id);
	}

}
