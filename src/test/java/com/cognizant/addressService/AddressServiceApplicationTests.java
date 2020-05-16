package com.cognizant.addressService;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.addressService.controller.AddressController;

@SpringBootTest
class AddressServiceApplicationTests {
	@Autowired
	private AddressController ac;
	@Test
	void contextLoads() {
		
		assertThat(ac).isNotNull();
	}

}
