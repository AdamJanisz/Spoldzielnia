package pl.dmcs.ajanisz.service;

import pl.dmcs.ajanisz.domain.AppUser;
import pl.dmcs.ajanisz.domain.Bills;

import javax.servlet.http.HttpServletResponse;

public interface PdfService {
    public void generatePdf(Bills bill, HttpServletResponse response);
}
