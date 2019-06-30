package pl.dmcs.ajanisz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dmcs.ajanisz.dao.BillsRepository;
import pl.dmcs.ajanisz.domain.Bills;

@Transactional
@Service
public class BillsServiceImpl implements BillsService{
    @Autowired
    BillsRepository billsRepository;

    @Transactional
    public void addBills(Bills bills) {
        billsRepository.save(bills);

    }

    @Transactional
    public Bills getBills(long id) {
        return billsRepository.findBy(id);
    }
}
