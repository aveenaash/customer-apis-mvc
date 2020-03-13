package com.rab3.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rab3.dtos.AddressDto;
import com.rab3.dtos.CustomerDto;
import com.rab3.dtos.LoginDto;
import com.rab3.entities.AddressEntity;
import com.rab3.entities.CustomerEntity;
import com.rab3.entities.LoginEntity;
import com.rab3.repositories.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public void createCustomer(CustomerDto customerDto) {
		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setFname(customerDto.getFname());
		customerEntity.setLname(customerDto.getLname());
		customerEntity.setEmail(customerDto.getEmail());
		customerEntity.setPhone(customerDto.getPhone());
		customerEntity.setCreatedDate(new Date());
		customerEntity.setUpdatedDate(new Date());

		AddressDto addressDto = customerDto.getAddress();
		AddressEntity addressEntity = new AddressEntity();

		addressEntity.setAddress1(addressDto.getAddress1());
		addressEntity.setAddress2(addressDto.getAddress2());
		addressEntity.setCity(addressDto.getCity());
		addressEntity.setState(addressDto.getState());
		addressEntity.setZip(addressDto.getZip());
		addressEntity.setCustomerEntity(customerEntity);
		customerEntity.setAddressEntity(addressEntity);

		LoginDto loginDto = customerDto.getLogin();
		LoginEntity loginEntity = new LoginEntity();

		loginEntity.setUsername(loginDto.getUsername());
		loginEntity.setPassword(loginDto.getPassword());
		loginEntity.setCustomerEntity(customerEntity);

		loginEntity.setCreatedDate(new Date());
		loginEntity.setLastSignIn(new Date());
		loginEntity.setUpdatedDate(new Date());
		customerEntity.setLoginEntity(loginEntity);

		customerRepository.save(customerEntity);

	}

}