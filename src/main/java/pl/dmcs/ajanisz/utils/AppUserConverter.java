package pl.dmcs.ajanisz.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.dmcs.ajanisz.domain.AppUser;
import pl.dmcs.ajanisz.service.AppUserService;

public class AppUserConverter implements Converter<String, AppUser> {

    @Autowired
    AppUserService appUserService;

        @Override
        public AppUser convert(String s) {
            return appUserService.getAppUser(Integer.parseInt(s));
        }


}
