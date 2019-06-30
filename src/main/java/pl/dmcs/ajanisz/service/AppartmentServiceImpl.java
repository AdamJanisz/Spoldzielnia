package pl.dmcs.ajanisz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dmcs.ajanisz.dao.AppartmentRepository;
import pl.dmcs.ajanisz.domain.Appartment;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Transactional
@Service
public class AppartmentServiceImpl implements  AppartmentService{

   @Autowired
   AppartmentRepository appartmantRepository;

    @Transactional
    public void addAppartment(Appartment appartment) {
        appartmantRepository.save(appartment);
    }

    @Transactional
    public Appartment getAppartment(long id) {
        return  appartmantRepository.findById(id);
    }

    @Transactional
    public Set<Appartment> listAppartment() {
        Set<Appartment> appartmentSet= new HashSet<Appartment>();
        appartmentSet.addAll(appartmantRepository.findAll());
        return  appartmentSet;}

    @Override
    public void removeAppartment(long id) {
     appartmantRepository.delete(id);
    }

}

