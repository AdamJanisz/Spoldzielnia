package pl.dmcs.ajanisz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.dmcs.ajanisz.domain.AppUser;
import pl.dmcs.ajanisz.domain.AppUserRole;

@Transactional
@Repository
public interface AppUserRoleRepository extends JpaRepository<AppUserRole,Long>{

AppUserRole findByRole(String role);

}

