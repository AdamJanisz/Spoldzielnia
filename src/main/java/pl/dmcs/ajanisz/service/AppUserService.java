package pl.dmcs.ajanisz.service;


import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import pl.dmcs.ajanisz.domain.AppUser;
import java.util.List;

public interface AppUserService {

	public void addAppUser(AppUser user);
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void editAppUser(AppUser user);
	public  List<AppUser> listAppUser();
	@Secured("ROLE_ADMIN")
	public void removeAppUser(long id);
	public AppUser getAppUser(long id);
    public AppUser findByLogin(String login);
}
