package com.cognizant.addressService.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import com.cognizant.addressService.model.Address;

public interface AddService {
	
	CompletableFuture<Address> createAddress(Address address);
	CompletableFuture<Optional<Address>> getAddressById(int id);
	CompletableFuture<List<Address>> getByStreetName(String name);
	CompletableFuture<List<Address>> getByCity(String name);
	CompletableFuture<List<Address>> getByCountry(String name);
	public void updateById(Address address);
	public void deleteById(int id);
	public CompletableFuture<Iterable<Address>> findAllAdd();

}
