package pl.dmcs.ajanisz.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dmcs.ajanisz.domain.Address;
import pl.dmcs.ajanisz.domain.Appartment;
import pl.dmcs.ajanisz.service.AppUserService;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface AppartmentRepository extends JpaRepository<Appartment,Long> {


        Appartment findById(long id);
        List<Appartment> findAllByAppartmentAddress(Address address);




}
