package com.rab3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rab3.dtos.CustomerDto;
import com.rab3.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	
	@Autowired
	private CustomerService customerService;
	
	
	@PostMapping
	public void createCustomer(@RequestBody CustomerDto dto) {
		customerService.createCustomer(dto);
		
		
	}
	
	
//	@GetMapping(value="/add")
//	public void addAddress(@RequestParam(value="id",required=true)int customerId,@RequestBody AddressDto addressDto) {
//		addressService.createAddress(customerId, addressDto);
//	}
//	
//	
//	@PostMapping(value="/log")
//	public void createLogin(@RequestParam(value="id",required=true)int customerId,@RequestBody LoginDto loginDto) {
//		loginService.createLogin(customerId, loginDto);
//	}
	

}
