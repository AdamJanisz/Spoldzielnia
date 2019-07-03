package pl.dmcs.ajanisz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.dmcs.ajanisz.service.BillsService;
import pl.dmcs.ajanisz.service.PdfService;

import javax.servlet.http.HttpServletResponse;

@Controller
public class PdfController {

    @Autowired
    PdfService pdfService;

    @Autowired
    BillsService billsService;

    @RequestMapping(value = "/generatePdf-{billId}",method = RequestMethod.GET)
    public void generatePdf(@PathVariable long billId, HttpServletResponse response){
        pdfService.generatePdf(billsService.getBills(billId),response);
    }
}
