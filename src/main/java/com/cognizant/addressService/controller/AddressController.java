package com.cognizant.addressService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.addressService.model.Address;
import com.cognizant.addressService.service.AddService;

@RestController
public class AddressController {
	@Autowired
	AddService service;
	@GetMapping("/address/id/{id}")
	public Optional<Address> getById(@PathVariable(value = "id")int id){
		return service.getAddressById(id);
	}
	@PostMapping("/address/create")
	public Address create(@RequestBody Address address) {
	    return service.createAddress(address);	
	}
	@GetMapping("/getaddresses")
	public Iterable<Address> getAll(){
		
		return service.getAllAddress();
	}
	@GetMapping("/address/perm/{permanentAddress}")
	public List<Address> getPermanent(@PathVariable String permanentAddress){
		return service.getByPermAdd(permanentAddress);
	}
	@GetMapping("/address/curr/{currentAddress}")
	public List<Address> getCurrent(@PathVariable String currentAddress){
		return service.getByCurrAdd(currentAddress);
	}
	@PutMapping("/updateaddress/{id}")
	public void updateAddress(@RequestBody Address address,@PathVariable int id) {
		Address add = new Address(address.getUser_id(),address.getPermanentAddress(),address.getPresentAddress());
		service.updateById(add);
	}
	@DeleteMapping("/deleteaddress/{id}")
	public void deleteAddress(@PathVariable int id) {
		service.deleteById(id);
	}
	
	
}
