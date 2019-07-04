package pl.dmcs.ajanisz.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pl.dmcs.ajanisz.domain.Address;


public class AddressValidator implements Validator {



    @Override
    public boolean supports(Class clazz) {
        return Address.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object arg0, Errors errors) {

        ValidationUtils.rejectIfEmpty(errors, "city", "error.field.required");
        ValidationUtils.rejectIfEmpty(errors, "street", "error.field.required");
        ValidationUtils.rejectIfEmpty(errors, "buildingNumber", "error.field.required");


    }
}
