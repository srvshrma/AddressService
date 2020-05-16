package com.cognizant.addressService;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cognizant.addressService.controller.AddressController;
import com.cognizant.addressService.service.AddService;
@WebMvcTest(AddressController.class)
public class AddressControllerTest {
	@Autowired
	private MockMvc mock;
	@MockBean
	private AddService ac;
	@Test
	void getByIdTest() throws Exception {
		
		mock.perform(MockMvcRequestBuilders.get("/address/id/{id}",1).accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
	}
}
