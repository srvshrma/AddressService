package com.cognizant.addressService.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.cognizant.addressService.config.AsyncResponse;
import com.cognizant.addressService.model.Address;
import com.cognizant.addressService.repository.AddressRepository;
@Service
public class AddServiceImpl implements AddService {
	@Autowired
	AddressRepository aRepo; 
	
	Logger logger = LoggerFactory.getLogger(AddService.class); 
	@Async
	public CompletableFuture<Iterable<Address>> findAllAdd(){
	
		logger.info("Get list of address by "+Thread.currentThread().getName());
			Iterable<Address> adds=aRepo.findAll();
			return CompletableFuture.completedFuture(adds);
			
	}
	@Async
	@Override
	public CompletableFuture<Optional<Address>> getAddressById(int id) {
		logger.info("get id of address by "+Thread.currentThread().getName());
		Optional<Address> adds=aRepo.findById(id);
		return CompletableFuture.completedFuture(adds);
	}
	@Async
	@Override
	public CompletableFuture<Address> createAddress(Address address) {
		// TODO Auto-generated method stub
		logger.info("Create address by "+Thread.currentThread().getName());
		/*AsyncResponse<Address> response=new AsyncResponse<Address>();
		try {
			Address create=aRepo.save(address);
			return CompletableFuture.completedFuture(create);
		} catch (Exception e) {
			logger.warn("Exception caught while finding address.",e);
			response.completeExceptionally(e);
		}
		return response;*/
		Address create=aRepo.save(address);
		return CompletableFuture.completedFuture(create);
	}
	@Async
	@Override
	public CompletableFuture<List<Address>> getByCity(String name) {
		// TODO Auto-generated method stub
		logger.info("get address by city by "+Thread.currentThread().getName());
		List<Address> byCity=aRepo.findByCity(name);
		return CompletableFuture.completedFuture(byCity);
				
	}
	@Async
	@Override
	public CompletableFuture<List<Address>> getByCountry(String name) {
		// TODO Auto-generated method stub
		logger.info("get address by country by "+Thread.currentThread().getName());
		List<Address> byCoun=aRepo.findByCountry(name);
		return CompletableFuture.completedFuture(byCoun);
	}
	@Async
	@Override
	public CompletableFuture<List<Address>> getByStreetName(String name) {
		logger.info("get address by street by "+Thread.currentThread().getName());
		List<Address> byStreet=aRepo.findByStreetName(name);
		return CompletableFuture.completedFuture(byStreet);
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
