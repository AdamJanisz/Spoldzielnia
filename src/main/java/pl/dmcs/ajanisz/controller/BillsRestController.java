package pl.dmcs.ajanisz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.dmcs.ajanisz.dao.BillsRepository;
import pl.dmcs.ajanisz.domain.Bills;

@RestController
@RequestMapping("billsRest")
public class BillsRestController {



    @Autowired
    BillsRepository billsRepository;

    @RequestMapping(value = "/{billId}", method = RequestMethod.GET, produces = "application/json")
    public Bills getInvoiceInJSON(@PathVariable Long billId) { return billsRepository.findById(billId);
    }

    @RequestMapping(value = "/{billId}.xml", method = RequestMethod.GET, produces = "application/xml")
    public Bills getInvoiceInXML(@PathVariable Long billId) {
        return billsRepository.findById(billId);
    }

}
