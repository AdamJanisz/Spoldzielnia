package pl.dmcs.ajanisz.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.dmcs.ajanisz.domain.AppUserRole;
import pl.dmcs.ajanisz.service.AppUserRoleService;

import java.util.HashSet;
import java.util.Set;

public class AppUserRoleListConverter implements Converter<String[], Set<AppUserRole>> {

    @Autowired
    AppUserRoleService appUserRoleService;

    @Override
    public Set<AppUserRole> convert(String[] source) {
        Set<AppUserRole> userRoleList = new HashSet<AppUserRole>(0);

        for (int i=0; i< source.length; i++)
        {
            userRoleList.add(appUserRoleService.getAppUserRole(Integer.parseInt(source[i])));
        }
        return userRoleList;
    }
}
