package pl.dmcs.ajanisz.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import pl.dmcs.ajanisz.domain.Address;

import java.util.List;


public interface AddressService {

    @Secured("ROLE_ADMIN")
    public void addAddress(Address address);

    public List<Address> listAddress();
    @PreAuthorize("hasRole('ROLE_ADMIN') OR (#address.owner.login == principal.username)")
    public void editAddress(Address address);
    @PreAuthorize("hasRole('ROLE_ADMIN') OR (#address.owner.login == principal.username)")
    public void removeAddress(long id);
    public Address getAddress(long id);

}
