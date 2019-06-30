package pl.dmcs.ajanisz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dmcs.ajanisz.dao.AppUserRoleRepository;
import pl.dmcs.ajanisz.domain.AppUserRole;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AppUserRoleServiceImpl implements AppUserRoleService {

    @Autowired
    AppUserRoleRepository appUserRoleRepository;


    @Transactional
    public void addAppUserRole(AppUserRole appUserRole) {
        appUserRoleRepository.save(appUserRole);
    }

    @Transactional
    public List<AppUserRole> listAppUserRole() {
        return appUserRoleRepository.findAll();
    }

    @Transactional
    public AppUserRole getAppUserRole(long id) {
        return appUserRoleRepository.getOne(id);
    }

    @Transactional
    public Set<AppUserRole> getUserRole(String role) {
        Set <AppUserRole> userRoleSet=new HashSet<AppUserRole>();
        userRoleSet.add(appUserRoleRepository.findByRole(role));
        return userRoleSet;
    }
}
