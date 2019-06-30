package pl.dmcs.ajanisz.service;

import pl.dmcs.ajanisz.domain.Bills;

public interface BillsService {


        public void addBills(Bills bills);
        public Bills getBills(long id);
    }

