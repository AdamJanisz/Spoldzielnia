package pl.dmcs.ajanisz.service;


import pl.dmcs.ajanisz.domain.AppUserRole;

import java.util.List;
import java.util.Set;

public interface AppUserRoleService {
    void addAppUserRole(AppUserRole appUserRole);
    List<AppUserRole> listAppUserRole();
    AppUserRole getAppUserRole(long id);
    Set<AppUserRole> getUserRole(String role);
}
