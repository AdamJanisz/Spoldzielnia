package pl.dmcs.ajanisz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dmcs.ajanisz.domain.AppUser;
import pl.dmcs.ajanisz.domain.AppUserRole;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    List<AppUser> findByLastName(String lastName);
    AppUser findById(long id);
    AppUser findByLogin(String login);
    List<AppUser> findAllByAppUserRole(AppUserRole role);
}
