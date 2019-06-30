package pl.dmcs.ajanisz.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import pl.dmcs.ajanisz.domain.Address;

import java.util.List;


public interface AddressService {

    public void addAddress(Address address);

    public List<Address> listAddress();
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void editAddress(Address address);
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void removeAddress(long id);
    public Address getAddress(long id);

}
