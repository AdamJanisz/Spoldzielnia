package pl.dmcs.ajanisz.service;

import org.springframework.security.access.prepost.PreAuthorize;
import pl.dmcs.ajanisz.domain.Address;
import pl.dmcs.ajanisz.domain.Appartment;

import java.util.List;
import java.util.Set;

public interface AppartmentService {

    public void addAppartment(Appartment appartment);
    public Appartment getAppartment(long id);
    public Set<Appartment> listAppartment();
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void removeAppartment(long id);

}
