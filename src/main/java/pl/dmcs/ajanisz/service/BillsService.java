package pl.dmcs.ajanisz.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import pl.dmcs.ajanisz.domain.AppUser;
import pl.dmcs.ajanisz.domain.Bills;

import java.util.List;

public interface BillsService {

        public List<Bills> listBills();
        public List<Bills> listUserBills(long id);
        public void addBills(Bills bills);
        @PreAuthorize("hasRole('ROLE_ADMIN') OR (#bills.appUser.login == principal.username)")
        public void editBills(Bills bills);
        public Bills getBills(long id);
        @PreAuthorize("hasRole('ROLE_ADMIN')")
        public void removeBill(long id);
        public Bills calculateTotalAmount(Bills bill);
        public void updateBill(int coldWater,long id);

    }

