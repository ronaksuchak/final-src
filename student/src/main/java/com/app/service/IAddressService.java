package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.Address;
public interface IAddressService {

	Optional<Address> getAddress(Integer addressId);

	Address setAddress(Address address);
	
    List<Address> getAll();

 }
