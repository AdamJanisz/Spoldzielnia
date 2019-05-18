package pl.dmcs.ajanisz.service;


import pl.dmcs.ajanisz.domain.AppUser;
import java.util.List;

public interface AppUserService {

	public void addAppUser(AppUser user);
	public void editAppUser(AppUser user);
	public  List<AppUser> listAppUser();
	public void removeAppUser(long id);
	public AppUser getAppUser(long id);
    public AppUser findByLogin(String login);
}
