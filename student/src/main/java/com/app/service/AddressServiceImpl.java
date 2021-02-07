package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.AddressRepository;
import com.app.pojos.Address;

@Service // mandatory
@Transactional // optional since it's by default already added on JpaRepository
public class AddressServiceImpl implements IAddressService {
	// dependency
	@Autowired
	private AddressRepository  addressRepo;

	@Override
	public Optional<Address> getAddress(Integer addressId) {
		Optional<Address> a=addressRepo.findById(addressId);
		//return addressRepo.findById(addressId).orElse(null);
		return a;
	}

	@Override
	public List<Address> getAll() {
		// TODO Auto-generated method stub
		return addressRepo.findAll();
	}

	@Override
	public Address setAddress(Address address) {
		
		return addressRepo.save(address);
	}

}
