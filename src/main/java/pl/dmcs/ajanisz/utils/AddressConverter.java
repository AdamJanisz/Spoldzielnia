package pl.dmcs.ajanisz.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.dmcs.ajanisz.domain.Address;
import pl.dmcs.ajanisz.service.AddressService;

public class AddressConverter implements Converter<String, Address> {

	@Autowired
	AddressService addressService;
	
	@Override
	public Address convert(String s) {
		return addressService.getAddress(Integer.parseInt(s));
	}
}


