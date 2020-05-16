package com.cognizant.addressService.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.addressService.exception.AddressNotFoundException;
import com.cognizant.addressService.exception.ExceptionMessage;
import com.cognizant.addressService.model.Address;
import com.cognizant.addressService.service.AddService;

@RestController
public class AddressController {
	@Autowired
	AddService service;
	@GetMapping(value="/addresses",produces="application/json")
	public CompletableFuture<ResponseEntity<Iterable<Address>>> findAllAdds() throws AddressNotFoundException{
		CompletableFuture<ResponseEntity<Iterable<Address>>> address=service.findAllAdd().thenApply(ResponseEntity::ok);
		if(address==null) throw new AddressNotFoundException(ExceptionMessage.EMPTY.getMessage());
		return address;
	}
	
	
	@GetMapping("/address/id/{id}")
	public CompletableFuture<ResponseEntity> getById(@Valid@PathVariable(value = "id")int id) throws AddressNotFoundException{
		CompletableFuture<ResponseEntity> address=service.getAddressById(id).thenApply(ResponseEntity::ok);
		if(address==null) {
		address.completeExceptionally(new AddressNotFoundException(ExceptionMessage.EMPTY.getMessage()));}
		return address; 
	}
	@PostMapping("/address/create")
	public CompletableFuture<ResponseEntity<Address>> create(@RequestBody Address address){
	    return service.createAddress(address).thenApply(ResponseEntity::ok);	
	}
	
	@GetMapping("/address/street/{name}")
	public CompletableFuture<ResponseEntity<List<Address>>> getStreet(@PathVariable String name) throws AddressNotFoundException{
		
		return service.getByStreetName(name).thenApply(ResponseEntity::ok);
	}
	@GetMapping("/address/city/{name}")
	public CompletableFuture<ResponseEntity<List<Address>>> getCity(@PathVariable String name) throws AddressNotFoundException{
		return service.getByCity(name).thenApply(ResponseEntity::ok);
	}
	@GetMapping("/address/country/{name}")
	public CompletableFuture<ResponseEntity<List<Address>>> getCountry(@PathVariable String name) throws AddressNotFoundException{
		return service.getByCountry(name).thenApply(ResponseEntity::ok);
	}
	
	@PutMapping("/updateaddress/{id}")
	public void updateAddress(@RequestBody Address address,@PathVariable int id) {
		Address add = new Address(address.getUser_id(),address.getCity(),address.getCountry(),address.getStreetName(),address.getPinCode(),address.getHouseNo());
		service.updateById(add);
	}
	@DeleteMapping("/deleteaddress/{id}")
	public void deleteAddress(@PathVariable int id) {
		
		service.deleteById(id);
	}
	
	
}
