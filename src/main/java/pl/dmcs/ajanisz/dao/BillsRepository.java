package pl.dmcs.ajanisz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dmcs.ajanisz.domain.Bills;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface BillsRepository extends JpaRepository<Bills,Long> {

    Bills findBy(long id);

}
