package pl.dmcs.ajanisz.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.dmcs.ajanisz.domain.Appartment;
import pl.dmcs.ajanisz.service.AppartmentService;

public class AppartmentConverter implements Converter<String, Appartment> {
    @Autowired
    AppartmentService appartmentService;

    public Appartment convert(String s) { return appartmentService.getAppartment((Integer.parseInt(s))); }
}
