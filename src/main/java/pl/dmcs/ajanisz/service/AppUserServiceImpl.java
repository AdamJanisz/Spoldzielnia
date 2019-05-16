package pl.dmcs.ajanisz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dmcs.ajanisz.dao.AppUserRepository;
import pl.dmcs.ajanisz.domain.AppUser;

import java.util.List;

@Service
public class AppUserServiceImpl implements AppUserService {

	@Autowired
    AppUserRepository appUserRepository;

	@Transactional
	public void addAppUser(AppUser appUser) {
        appUserRepository.save(appUser);
	}

	@Transactional
	public void editAppUser(AppUser appUser) {
        appUserRepository.save(appUser);
	}

	@Transactional
	public List<AppUser> listAppUser() {
		return appUserRepository.findAll();
	}

	@Transactional
	public void removeAppUser(long id) {
        appUserRepository.delete(id);
	}

	@Override
	public AppUser getAppUser(long id) {
		return appUserRepository.findById(id);
	}


}


